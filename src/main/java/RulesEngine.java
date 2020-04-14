import javafx.util.Pair;

public class RulesEngine {

    private final Pair<Integer,Integer>  BOTH_COOPERATE=new Pair<>(2,2);
    private final Pair<Integer,Integer>  BOTH_CHEAT=new Pair<>(0,0);
    private final Pair<Integer,Integer>  FIRST_COOPERATE_SECOND_CHEAT=new Pair<>(-1,3);
    private final Pair<Integer,Integer>  FIRST_CHEAT_SECOND_COOPERATE=new Pair<>(3,-1);

    public Pair<Integer, Integer> getScoreForMoves(MoveTypes player1Move, MoveTypes player2Move) {
        if (player1Move == MoveTypes.Cooperate && player2Move==MoveTypes.Cooperate) return BOTH_COOPERATE;
        if (player1Move == MoveTypes.Cheat && player2Move==MoveTypes.Cooperate) return FIRST_CHEAT_SECOND_COOPERATE;
        if (player1Move == MoveTypes.Cooperate && player2Move==MoveTypes.Cheat) return FIRST_COOPERATE_SECOND_CHEAT;
        return BOTH_CHEAT;
    }

}

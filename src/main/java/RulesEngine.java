import javafx.util.Pair;

public class RulesEngine {

    public final Pair<Score,Score>  BOTH_COOPERATE=new Pair<>(new Score(2),new Score(2));
    public final Pair<Score,Score>  BOTH_CHEAT=new Pair<>(new Score(0),new Score(0));
    public final Pair<Score,Score>  FIRST_COOPERATE_SECOND_CHEAT=new Pair<>(new Score(-1),new Score(3));
    public final Pair<Score,Score>  FIRST_CHEAT_SECOND_COOPERATE=new Pair<>(new Score(3),new Score(-1));

    public Pair<Score, Score> getScoreForMoves(MoveTypes player1Move, MoveTypes player2Move) {
        if (player1Move == MoveTypes.Cooperate && player2Move==MoveTypes.Cooperate) return BOTH_COOPERATE;
        if (player1Move == MoveTypes.Cheat && player2Move==MoveTypes.Cooperate) return FIRST_CHEAT_SECOND_COOPERATE;
        if (player1Move == MoveTypes.Cooperate && player2Move==MoveTypes.Cheat) return FIRST_COOPERATE_SECOND_CHEAT;
        return BOTH_CHEAT;
    }

}

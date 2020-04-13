import javafx.util.Pair;

public class RulesEngine {

    public static Pair<Integer, Integer> moveAndGetScore(MoveTypes player1Move, MoveTypes player2Move) {
        if (player1Move == MoveTypes.Cooperate && player2Move==MoveTypes.Cooperate) return new Pair<>(2, 2);
        if (player1Move == MoveTypes.Cheat && player2Move==MoveTypes.Cooperate) return new Pair<>(3, -1);
        if (player1Move == MoveTypes.Cooperate && player2Move==MoveTypes.Cheat) return new Pair<>(-1, 3);
        return new Pair<>(0,0);
    }

}

import javafx.util.Pair;

public class Game {


    private Player player1;
    private Player player2;
    private RulesEngine rulesEngine;

    public Game(Player player1, Player player2, RulesEngine rulesEngine) {
        this.player1 = player1;
        this.player2 = player2;
        this.rulesEngine = rulesEngine;
    }

    public void playOnce() {
      Pair<Integer,Integer> score=  rulesEngine.getScoreForMoves(player1.getCurrentMove(),player2.getCurrentMove());
      player1.updateScore(score.getKey());
      player2.updateScore(score.getKey());
    }
}

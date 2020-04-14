import javafx.util.Pair;
import java.io.PrintStream;

public class Game {
    private Integer round = 0;
    private PlayerScore playerScore1;
    private PlayerScore playerScore2;

    private Player player1;
    private Player player2;

    private RulesEngine rulesEngine;
    private PrintStream printStream;

    public Game(Player player1, Player player2, RulesEngine rulesEngine, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.playerScore1 = new PlayerScore(1, new Score(0));
        this.playerScore2 = new PlayerScore(2, new Score(0));
        this.rulesEngine = rulesEngine;
        this.printStream = printStream;
    }

    public void playOnce() {
        updateRound();
        Pair<Score, Score> score = rulesEngine.getScoreForMoves(player1.getCurrentMove(), player2.getCurrentMove());
        updateScores(score);
        displayScores();
    }

    private void updateRound() {
        round++;
    }

    private void updateScores(Pair<Score, Score> score) {
        playerScore1.updateScore(playerScore1.getScore().combine(score.getKey()));
        playerScore2.updateScore(playerScore2.getScore().combine(score.getValue()));
    }

    private void displayScores() {
        printStream.println("Round:" + round);
        printStream.println("Player 1 Score:" + playerScore1.getScore());
        printStream.println("Player 2 Score:" + playerScore2.getScore());
        printStream.println();
    }

    public Score scoreFor(Player player) {
        if (player == player1) return playerScore1.getScore();
        if (player == player2) return playerScore2.getScore();
        return null;
    }
}


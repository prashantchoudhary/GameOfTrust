import javafx.util.Pair;

import java.io.PrintStream;

public class Game {
    private Integer round = 0;
    private Player player1;
    private Player player2;
    private RulesEngine rulesEngine;
    private PrintStream printStream;

    public Game(Player player1, Player player2, RulesEngine rulesEngine, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.rulesEngine = rulesEngine;
        this.printStream = printStream;
    }

    public void playOnce() {
        updateRound();
        Pair<Integer, Integer> score = rulesEngine.getScoreForMoves(player1.getCurrentMove(), player2.getCurrentMove());
        updateScores(score);
        displayScores();
    }

    private void updateRound() {
        round++;
    }

    private void updateScores(Pair<Integer, Integer> score) {
        player1.updateScore(player1.getScore() + score.getKey());
        player2.updateScore(player2.getScore() + score.getKey());
    }

    private void displayScores() {
        printStream.println("Round:" + round);
        printStream.println("Player 1 Score:" + player1.getScore());
        printStream.println("Player 2 Score:" + player2.getScore());
        printStream.println();
    }
}


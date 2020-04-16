import javafx.util.Pair;

import java.io.PrintStream;
import java.util.Observable;

public class Game extends Observable {
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

    private void playOnce() {
        updateRound();
        MoveTypes player1move=playPlayerMove(player1);
        MoveTypes player2move=playPlayerMove(player2);

        Pair<Score, Score> score = rulesEngine.getScoreForMoves(player1move, player2move);
        updateScores(score);
        displayScores();
    }

    private MoveTypes playPlayerMove(Player player){
        MoveTypes currentMove=player.getCurrentMove();
        setChanged();
        notifyObservers(currentMove);
        return currentMove;
    }


    public void playFor(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            playOnce();
        }
    }

    public Score scoreFor(Player player) {
        if (player == player1) return playerScore1.getScore();
        if (player == player2) return playerScore2.getScore();
        return null;
    }
}


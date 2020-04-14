public class PlayerScore {
    private final int playerId;
    private Score score;

    PlayerScore(int player, Score score) {
        this.playerId = player;
        this.score = score;
    }

    public Score getScore() {
        return score;
    }

    public void updateScore(Score score) {
        this.score = score;
    }
}

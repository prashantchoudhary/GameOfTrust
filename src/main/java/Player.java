public class Player {

    private MoveTypes moveType;
    private int score;

    public Player(MoveTypes moveType) {

        this.moveType = moveType;
    }

    public MoveTypes getCurrentMove() {
        return this.moveType;
    }

    public Integer getScore() {
        return score;
    }

    public void updateScore(Integer score) {
        this.score = score;
    }
}

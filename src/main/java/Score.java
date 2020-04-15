public class Score {
    private int score;

    public Score(int score) {

        this.score = score;
    }

    public Score combine(Score newScore) {
        return new Score(this.score + newScore.score);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Score)) return false;
        return this.score == ((Score)o).score;
    }

    @Override
    public String toString() {
        return Integer.toString( this.score);
    }
}

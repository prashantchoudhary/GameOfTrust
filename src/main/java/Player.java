public class Player {

    private MoveTypes moveType;

    public Player(MoveTypes moveType) {

        this.moveType = moveType;
    }

    public MoveTypes getCurrentMove() {
        return this.moveType;
    }
}

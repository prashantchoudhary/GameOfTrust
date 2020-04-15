public class Player implements Behaviour {

    private Behaviour behaviour;

    public Player(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public MoveTypes getCurrentMove() {
        return this.behaviour.getCurrentMove();
    }
}


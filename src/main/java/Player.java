public class Player implements Behaviour {

    private Behaviour behaviour;
    private final String name;

    public Player(Behaviour behaviour) {
        this.behaviour = behaviour;
        this.name="";
    }
    public Player(Behaviour behaviour,String name) {
        this.behaviour = behaviour;
        this.name = name;
    }

    public String getName(){return this.name;}

    public MoveTypes getCurrentMove() {
        return this.behaviour.getCurrentMove();
    }
}


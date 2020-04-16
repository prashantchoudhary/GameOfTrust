import java.util.Observable;
import java.util.Observer;

public class CopyCatBehaviour implements Behaviour, Observer {
    private boolean bFirst = true;
    private MoveTypes currentMove;

    @Override
    public MoveTypes getCurrentMove() {
        if (bFirst)
        {
            bFirst=false;
            return MoveTypes.COOPERATE;
        }
        return currentMove;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.currentMove = (MoveTypes) arg;
    }

}

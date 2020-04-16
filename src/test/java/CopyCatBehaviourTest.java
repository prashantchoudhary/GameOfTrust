import org.junit.Test;

import java.util.Observable;

import static org.junit.Assert.assertEquals;

public class CopyCatBehaviourTest {
    @Test
    public void whenCopyCatPlaysFirstBehaviourIsToCooperate() {
        Behaviour behaviour = new CopyCatBehaviour();
        assertEquals(MoveTypes.COOPERATE, behaviour.getCurrentMove());
    }

    @Test
    public void whenOtherPlayerCheatsExpectCopyCatToCheat() {
        ObservableTest lastMoveObservable = new ObservableTest();
        CopyCatBehaviour behaviour = new CopyCatBehaviour();
        lastMoveObservable.addObserver(behaviour);
        lastMoveObservable.playOnce();
        assertEquals(MoveTypes.COOPERATE, behaviour.getCurrentMove());
        lastMoveObservable.playOnce();
        assertEquals(MoveTypes.CHEAT, behaviour.getCurrentMove());
    }

    public class ObservableTest extends Observable {
        public void playOnce() {
            super.setChanged();
            super.notifyObservers(MoveTypes.CHEAT);
        }

    }
}
//Events
//Callbacks
//Observer
//Pub-Sub

//  Behaviour acts as both
//Observer and Observable


//Behaviour (copying behaviours)
//Notification. private method copyBehaviour(otherbehavioru)
//this.behvaiour=other.behviour

//getCurrentehv()
//other.behaviour=this.bcurrentbehvaiour


//CopycatBevaior behaviour=new CccBheave(consolePlayer);
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CopyCatBehaviourTest {
    @Test
    public void whenCopyCatPlaysFirstBehaviourIsToCooperate() {
        Behaviour behaviour=new CopyCatBehaviour();
        assertEquals(MoveTypes.COOPERATE,behaviour.getCurrentMove());
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
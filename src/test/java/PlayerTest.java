import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void forCooperatingPlayerBehaviourIsCooperate() {
        Player player1=new Player(MoveTypes.Cooperate);
        assertEquals(MoveTypes.Cooperate,player1.getCurrentMove());
    }
}

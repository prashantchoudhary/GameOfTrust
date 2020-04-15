import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    private Scanner scanner= mock(Scanner.class);
    private Behaviour behaviour= mock(Behaviour.class);

    @Test
    public void forCooperatingPlayerBehaviourIsCooperate() {
        when(behaviour.getCurrentMove()).thenReturn(MoveTypes.COOPERATE);
        Player player1=new Player(behaviour);
        assertEquals(MoveTypes.COOPERATE,player1.getCurrentMove());
    }

    @Test
    public void forCheatingPlayerBehaviourIsCheat() {
        when(behaviour.getCurrentMove()).thenReturn(MoveTypes.CHEAT);
        Player player1=new Player(behaviour);
        assertEquals(MoveTypes.CHEAT,player1.getCurrentMove());
    }
}

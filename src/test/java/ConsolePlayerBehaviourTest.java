import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsolePlayerBehaviourTest {

    private Scanner scanner= mock(Scanner.class);;

    @Test
    public void WhenInputIsCHExpectMoveTypeAsCheat() {
        when(scanner.nextLine()).thenReturn("CH");
        ConsolePlayerBehaviour behaviour = new ConsolePlayerBehaviour(scanner);
        MoveTypes moveType = behaviour.getCurrentMove();
        assertEquals(MoveTypes.CHEAT, moveType);
    }

    @Test
    public void WhenInputIsCOExpectMoveTypeAsCooperate() {
        when(scanner.nextLine()).thenReturn("CO");
        ConsolePlayerBehaviour behaviour = new ConsolePlayerBehaviour(scanner);
        MoveTypes moveType = behaviour.getCurrentMove();
        assertEquals(MoveTypes.COOPERATE, moveType);
    }
}

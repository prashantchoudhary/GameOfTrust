import javafx.util.Pair;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private Scanner scanner = mock(Scanner.class);

    @Test
    public void whenBothPlayersAreCooperatingExpectScoreTwoEach() {
        Player player1 =mock(Player.class);
        when(player1.getCurrentMove()).thenReturn(MoveTypes.COOPERATE);
        Player player2 =mock(Player.class);
        when(player2.getCurrentMove()).thenReturn(MoveTypes.COOPERATE);

        RulesEngine rulesEngine =mock( RulesEngine.class);
        when(rulesEngine.getScoreForMoves(MoveTypes.COOPERATE,MoveTypes.COOPERATE))
                .thenReturn(new Pair<>(new Score(2),new Score(2)));

        Game game = new Game(player1, player2, rulesEngine, System.out);

        game.playFor(1);
        assertEquals(new Score(2), game.scoreFor(player1));
        assertEquals(new Score(2), game.scoreFor(player2));
    }

    @Test
    public void whenFirstPlayerIsCopyCatAndSecondIsCheatFor6RoundsExpectsScoresMinus1And3() {
     /*   Player player1 =mock(Player.class);
        when(player1.getCurrentMove()).thenReturn(MoveTypes.COOPERATE);

        CopyCatBehaviour copyCatPlayer = mock(CopyCatBehaviour.class);

        Player player1 = new Player(copyCatPlayer);
        Player player2 = new Player(cheatPlayer);

        RulesEngine rulesEngine = new RulesEngine();

        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.addObserver(copyCatPlayer);

        game.playFor(6);

        assertEquals(new Score(-1), game.scoreFor(player1));
        assertEquals(new Score(3), game.scoreFor(player2));*/
    }
}

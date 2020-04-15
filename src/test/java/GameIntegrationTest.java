import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameIntegrationTest {
    private Scanner scanner=mock(Scanner.class);
    @Test
    public void whenBothPlayersAreCooperatingForTwoRoundsExpectScoreFourEach() {
        Player player1 = new Player(new CooperateBehaviour());
        Player player2 = new Player(new CooperateBehaviour());
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(2);
        assertEquals(new Score(4), game.scoreFor(player1));
        assertEquals(new Score(4), game.scoreFor(player2));
    }

    @Test
    public void whenBothPlayersAreCooperatingForFiveRoundsExpectScoreTenEach() {
        Player player1 = new Player(new CooperateBehaviour());
        Player player2 = new Player(new CooperateBehaviour());
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(5);
        assertEquals(new Score(10), game.scoreFor(player1));
        assertEquals(new Score(10), game.scoreFor(player2));
    }

    @Test
    public void whenFirstCooperateSecondCheatForSingleRoundsExpectScoreMinus1And3() {
        Player player1 = new Player(new CooperateBehaviour());
        Player player2 = new Player(new CheatBehaviour());
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(1);
        assertEquals(new Score(-1), game.scoreFor(player1));
        assertEquals(new Score(3), game.scoreFor(player2));
    }

    @Test
    public void whenFirstCooperateSecondCheatForFiveRoundsExpectScoreMinus5And15() {
        Player player1 = new Player(new CooperateBehaviour());
        Player player2 = new Player(new CheatBehaviour());
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(5);
        assertEquals(new Score(-5), game.scoreFor(player1));
        assertEquals(new Score(15), game.scoreFor(player2));
    }

    @Test
    public void whenFirstCooperateConsolePlayerAlwaysCheatsForFiveRoundsExpectScoreMinus5And15() {
        when(scanner.nextLine())
                .thenReturn("CH")
                .thenReturn("CH")
                .thenReturn("CH")
                .thenReturn("CH")
                .thenReturn("CH");
        Player player1 = new Player(new CooperateBehaviour());
        Player player2 = new Player(new ConsolePlayerBehaviour(scanner));
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(5);
        assertEquals(new Score(-5), game.scoreFor(player1));
        assertEquals(new Score(15), game.scoreFor(player2));
    }

    @Test
    public void whenFirstPlayerAndConsolePlayerAlwaysCheatsForFiveRoundsExpectScoresZero() {
        when(scanner.nextLine())
                .thenReturn("CH")
                .thenReturn("CH")
                .thenReturn("CH")
                .thenReturn("CH")
                .thenReturn("CH");
        Player player1 = new Player(new CheatBehaviour());
        Player player2 = new Player(new ConsolePlayerBehaviour(scanner));
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(5);
        assertEquals(new Score(0), game.scoreFor(player1));
        assertEquals(new Score(0), game.scoreFor(player2));
    }

    @Test
    public void whenFirstPlayerCheatsAndConsolePlayerPlaysSequenceCHCOCHCOCHForFiveRoundsExpectScoreMinus5And15() {
        when(scanner.nextLine())
                .thenReturn("CH")
                .thenReturn("CO")
                .thenReturn("CH")
                .thenReturn("CO")
                .thenReturn("CH");

        Player player1 = new Player(new CheatBehaviour());
        Player player2 = new Player(new ConsolePlayerBehaviour(scanner));
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(5);
        assertEquals(new Score(6), game.scoreFor(player1));
        assertEquals(new Score(-2), game.scoreFor(player2));
    }
}

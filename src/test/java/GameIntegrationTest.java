import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameIntegrationTest {
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
        System.setIn(new ByteArrayInputStream("CH\nCH\nCH\nCH\nCH".getBytes()));
        Scanner scanner = new Scanner(System.in);

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
        System.setIn(new ByteArrayInputStream("CH\nCH\nCH\nCH\nCH".getBytes()));
        Scanner scanner = new Scanner(System.in);

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
        System.setIn(new ByteArrayInputStream("CH\nCO\nCH\nCO\nCH".getBytes()));
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player(new CheatBehaviour());
        Player player2 = new Player(new ConsolePlayerBehaviour(scanner));
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(5);
        assertEquals(new Score(6), game.scoreFor(player1));
        assertEquals(new Score(-2), game.scoreFor(player2));
    }


    @Test
    public void whenOpponentPlayerPlaysFirstRoundExpectsToNotifyMoveType() {
        CopyCatBehaviour copyCatPlayer1 = new CopyCatBehaviour();
        CopyCatBehaviour copyCatPlayer2 = new CopyCatBehaviour();
        Player player1 = new Player(copyCatPlayer1);
        Player player2 = new Player(copyCatPlayer2);

        RulesEngine rulesEngine = new RulesEngine();

        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.addObserver(copyCatPlayer1);
        game.addObserver(copyCatPlayer2);

        game.playFor(3);

        assertEquals(new Score(6), game.scoreFor(player1));
        assertEquals(new Score(6), game.scoreFor(player2));
    }

    @Test
    public void whenFirstPlayerPlaysCheatsAndSecondIsCopyCatFor3RoundsExpectsScoresBoth0() {
        Behaviour cheatPlayer = new CheatBehaviour();
        CopyCatBehaviour copyCatPlayer = new CopyCatBehaviour();
        Player player1 = new Player(cheatPlayer);
        Player player2 = new Player(copyCatPlayer);

        RulesEngine rulesEngine = new RulesEngine();

        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.addObserver(copyCatPlayer);

        game.playFor(2);

        assertEquals(new Score(3), game.scoreFor(player1));
        assertEquals(new Score(-1), game.scoreFor(player2));
    }

    @Test
    public void whenFirstPlayerIsCopyCatAndSecondIsCheatFor6RoundsExpectsScoresMinus1And3() {
        Behaviour cheatPlayer = new CheatBehaviour();
        CopyCatBehaviour copyCatPlayer = new CopyCatBehaviour();
        Player player1 = new Player(copyCatPlayer);
        Player player2 = new Player(cheatPlayer);

        RulesEngine rulesEngine = new RulesEngine();

        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.addObserver(copyCatPlayer);

        game.playFor(6);

        assertEquals(new Score(-1), game.scoreFor(player1));
        assertEquals(new Score(3), game.scoreFor(player2));
    }
}

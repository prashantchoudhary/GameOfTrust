import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void whenBothPlayersAreCooperatingExpectScoreTwoEach() {
        Player player1 = new Player(MoveTypes.Cooperate);
        Player player2 = new Player(MoveTypes.Cooperate);
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playOnce();
        assertEquals(new Score(2), game.scoreFor(player1));
        assertEquals(new Score(2), game.scoreFor(player2));
    }

    @Test
    public void whenBothPlayersAreCooperatingForTwoRoundsExpectScoreFourEach() {
        Player player1 = new Player(MoveTypes.Cooperate);
        Player player2 = new Player(MoveTypes.Cooperate);
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playOnce();
        game.playOnce();
        assertEquals(new Score(4), game.scoreFor(player1));
        assertEquals(new Score(4), game.scoreFor(player2));
    }

    @Test
    public void whenBothPlayersAreCooperatingForFiveRoundsExpectScoreTenEach() {
        Player player1 = new Player(MoveTypes.Cooperate);
        Player player2 = new Player(MoveTypes.Cooperate);
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        for (int i = 0; i < 5; i++) {
            game.playOnce();
        }
        assertEquals(new Score(10), game.scoreFor(player1));
        assertEquals(new Score(10), game.scoreFor(player2));
    }

}

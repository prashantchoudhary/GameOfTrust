import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void whenBothPlayersAreCooperatingExpectScoreTwoEach() {
        Player player1 = new Player(MoveTypes.Cooperate);
        Player player2 = new Player(MoveTypes.Cooperate);
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine);
        game.playOnce();
        assertEquals((Integer) 2, player1.getScore());
        assertEquals((Integer) 2, player2.getScore());
    }

}

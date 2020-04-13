import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RulesEngineTest {

    @Test
    public void BothHaveTwoCoinsIfBothCooperate() {
        Pair result = RulesEngine.moveAndGetScore(MoveTypes.Cooperate, MoveTypes.Cooperate);
        assertEquals(new Pair<>(2,2), result);
    }

    @Test
    public void FirstCheatsAndSecondCooperates() {
        Pair result = RulesEngine.moveAndGetScore(MoveTypes.Cheat, MoveTypes.Cooperate);
        assertEquals(new Pair<>(3,-1), result);
    }


    @Test
    public void SecondCheatsAndFirstCooperates() {
        Pair result = RulesEngine.moveAndGetScore(MoveTypes.Cooperate, MoveTypes.Cheat);
        assertEquals(new Pair<>(-1,3), result);
    }

    @Test
    public void BothHaveOneCoinIfBothCheat() {
        Pair result = RulesEngine.moveAndGetScore(MoveTypes.Cheat, MoveTypes.Cheat);
        assertEquals(new Pair<>(0,0), result);
    }
}
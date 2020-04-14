import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RulesEngineTest {

    private RulesEngine rulesEngine=new RulesEngine();
    @Test
    public void BothHaveTwoCoinsIfBothCooperate() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cooperate, MoveTypes.Cooperate);
        assertEquals(new Pair<>(2,2), result);
    }

    @Test
    public void FirstCheatsAndSecondCooperates() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cheat, MoveTypes.Cooperate);
        assertEquals(new Pair<>(3,-1), result);
    }


    @Test
    public void SecondCheatsAndFirstCooperates() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cooperate, MoveTypes.Cheat);
        assertEquals(new Pair<>(-1,3), result);
    }

    @Test
    public void BothHaveOneCoinIfBothCheat() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cheat, MoveTypes.Cheat);
        assertEquals(new Pair<>(0,0), result);
    }
}
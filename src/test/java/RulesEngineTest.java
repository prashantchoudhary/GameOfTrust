import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RulesEngineTest {

    private RulesEngine rulesEngine=new RulesEngine();
    @Test
    public void BothHaveTwoCoinsIfBothCooperate() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cooperate, MoveTypes.Cooperate);
        assertEquals(rulesEngine.BOTH_COOPERATE, result);
    }

    @Test
    public void FirstCheatsAndSecondCooperates() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cheat, MoveTypes.Cooperate);
        assertEquals(rulesEngine.FIRST_CHEAT_SECOND_COOPERATE, result);
    }


    @Test
    public void SecondCheatsAndFirstCooperates() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cooperate, MoveTypes.Cheat);
        assertEquals(rulesEngine.FIRST_COOPERATE_SECOND_CHEAT, result);
    }

    @Test
    public void BothHaveOneCoinIfBothCheat() {
        Pair result = rulesEngine.getScoreForMoves(MoveTypes.Cheat, MoveTypes.Cheat);
        assertEquals(rulesEngine.BOTH_CHEAT, result);
    }
}
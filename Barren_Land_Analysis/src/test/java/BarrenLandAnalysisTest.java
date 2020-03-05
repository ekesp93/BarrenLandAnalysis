import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class BarrenLandAnalysisTest {

    @Test
    public void singleBarrenTest() {
        AreaFinder areaFinder = new AreaFinder();
        List<List<Integer>> input = Utils.convertInputToIntegerList("{\"0 292 399 307\"}");
        String fertileArea = areaFinder.findFertileLandArea(input);
        assertEquals("116800 116800 ", fertileArea);
    }

    @Test
    public void multipleBarrenTest() {
        AreaFinder areaFinder = new AreaFinder();
        List<List<Integer>> input = Utils.convertInputToIntegerList(
                "{\"48 192 351 207\",\"48 392 351 407\",\"120 52 135 547\",\"260 52 275 547\"}");
        String fertileArea = areaFinder.findFertileLandArea(input);
        assertEquals("22816 192608 ", fertileArea);
    }
}

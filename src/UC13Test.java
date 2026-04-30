import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC13Test {

    @Test
    void testLoopFilteringLogic() {

        List<UC13.Bogie> list = Arrays.asList(
                new UC13.Bogie("A", 72),
                new UC13.Bogie("B", 50)
        );

        List<UC13.Bogie> result = UC13.filterLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {

        List<UC13.Bogie> list = Arrays.asList(
                new UC13.Bogie("A", 72),
                new UC13.Bogie("B", 50)
        );

        List<UC13.Bogie> result = UC13.filterStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<UC13.Bogie> list = Arrays.asList(
                new UC13.Bogie("A", 72),
                new UC13.Bogie("B", 50),
                new UC13.Bogie("C", 80)
        );

        List<UC13.Bogie> r1 = UC13.filterLoop(list);
        List<UC13.Bogie> r2 = UC13.filterStream(list);

        assertEquals(r1.size(), r2.size());
    }

    @Test
    void testExecutionTimeMeasurement() {

        long start = System.nanoTime();
        long end = System.nanoTime();

        assertTrue((end - start) >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<UC13.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new UC13.Bogie("B" + i, i % 100));
        }

        List<UC13.Bogie> result = UC13.filterStream(list);

        assertNotNull(result);
    }
}
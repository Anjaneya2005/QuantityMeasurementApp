import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC12Test {

    @Test
    void testFilter_HighCapacity() {

        List<UC12.Bogie> list = Arrays.asList(
                new UC12.Bogie("Sleeper", 72),
                new UC12.Bogie("AC Chair", 56),
                new UC12.Bogie("First Class", 24)
        );

        List<UC12.Bogie> result = UC12.filterHighCapacity(list);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_NoMatch() {

        List<UC12.Bogie> list = Arrays.asList(
                new UC12.Bogie("First Class", 24),
                new UC12.Bogie("AC Chair", 56)
        );

        List<UC12.Bogie> result = UC12.filterHighCapacity(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllMatch() {

        List<UC12.Bogie> list = Arrays.asList(
                new UC12.Bogie("Sleeper", 72),
                new UC12.Bogie("Luxury", 80)
        );

        List<UC12.Bogie> result = UC12.filterHighCapacity(list);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyList() {

        List<UC12.Bogie> list = new ArrayList<>();

        List<UC12.Bogie> result = UC12.filterHighCapacity(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_ExactBoundary() {

        List<UC12.Bogie> list = Arrays.asList(
                new UC12.Bogie("Test", 60)
        );

        List<UC12.Bogie> result = UC12.filterHighCapacity(list);

        assertTrue(result.isEmpty()); // 60 not included
    }
}
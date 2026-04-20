import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC2Test {

    @Test
    void testEquality_SameValue() {

        assertTrue(UC2.compareFeet(1.0, 1.0));
        assertTrue(UC2.compareInches(1.0, 1.0));
    }

    @Test
    void testEquality_DifferentValue() {

        assertFalse(UC2.compareFeet(1.0, 2.0));
        assertFalse(UC2.compareInches(1.0, 2.0));
    }

    @Test
    void testEquality_NullComparison() {

        UC2.Feet f = new UC2.Feet(1.0);
        assertFalse(f.equals(null));

        UC2.Inches i = new UC2.Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {

        UC2.Feet f = new UC2.Feet(1.0);
        assertFalse(f.equals("abc"));

        UC2.Inches i = new UC2.Inches(1.0);
        assertFalse(i.equals("abc"));
    }

    @Test
    void testEquality_SameReference() {

        UC2.Feet f = new UC2.Feet(1.0);
        assertTrue(f.equals(f));

        UC2.Inches i = new UC2.Inches(1.0);
        assertTrue(i.equals(i));
    }
}
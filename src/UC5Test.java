import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC5Test {

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0, UC5.convert(1.0, UC5.LengthUnit.FEET, UC5.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0, UC5.convert(24.0, UC5.LengthUnit.INCH, UC5.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0, UC5.convert(1.0, UC5.LengthUnit.YARD, UC5.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testConversion_CMToInches() {
        assertEquals(1.0, UC5.convert(2.54, UC5.LengthUnit.CM, UC5.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testConversion_Zero() {
        assertEquals(0.0, UC5.convert(0.0, UC5.LengthUnit.FEET, UC5.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testConversion_Negative() {
        assertEquals(-12.0, UC5.convert(-1.0, UC5.LengthUnit.FEET, UC5.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> UC5.convert(1.0, null, UC5.LengthUnit.FEET));
    }

    @Test
    void testConversion_InvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> UC5.convert(Double.NaN, UC5.LengthUnit.FEET, UC5.LengthUnit.INCH));
    }
}
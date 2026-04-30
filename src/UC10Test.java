import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC10Test {

    // ✅ LENGTH EQUALITY
    @Test
    void testLengthEquality() {
        assertTrue(
                new Quantity<>(1.0, LengthUnit.FEET)
                        .equals(new Quantity<>(12.0, LengthUnit.INCH))
        );
    }

    // ✅ WEIGHT EQUALITY
    @Test
    void testWeightEquality() {
        assertTrue(
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .equals(new Quantity<>(1000.0, WeightUnit.GRAM))
        );
    }

    // ✅ LENGTH CONVERSION
    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> q =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertEquals("Quantity(12.0, INCH)",
                q.convertTo(LengthUnit.INCH).toString());
    }

    // ✅ WEIGHT CONVERSION
    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> q =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertEquals("Quantity(1000.0, GRAM)",
                q.convertTo(WeightUnit.GRAM).toString());
    }

    // ✅ ADD LENGTH
    @Test
    void testAddition_Length() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCH);

        assertEquals("Quantity(2.0, FEET)",
                q1.add(q2).toString());
    }

    // ✅ ADD WEIGHT
    @Test
    void testAddition_Weight() {
        Quantity<WeightUnit> q1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals("Quantity(2.0, KILOGRAM)",
                q1.add(q2).toString());
    }

    // ✅ ADD WITH TARGET UNIT
    @Test
    void testAddition_TargetUnit() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCH);

        assertEquals("Quantity(24.0, INCH)",
                q1.add(q2, LengthUnit.INCH).toString());
    }

    // ✅ CROSS CATEGORY CHECK
    @Test
    void testCrossCategoryEquality() {
        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    // ✅ NULL UNIT CHECK
    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }
}
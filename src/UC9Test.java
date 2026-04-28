import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC9Test {

    @Test
    void testEquality_KgToGram() {
        assertTrue(
                new UC9.QuantityWeight(1.0, UC9.WeightUnit.KILOGRAM)
                        .equals(new UC9.QuantityWeight(1000.0, UC9.WeightUnit.GRAM))
        );
    }

    @Test
    void testEquality_KgToPound() {
        assertTrue(
                new UC9.QuantityWeight(1.0, UC9.WeightUnit.KILOGRAM)
                        .equals(new UC9.QuantityWeight(2.20462, UC9.WeightUnit.POUND))
        );
    }

    @Test
    void testConversion_KgToGram() {
        UC9.QuantityWeight q =
                new UC9.QuantityWeight(1.0, UC9.WeightUnit.KILOGRAM);

        assertEquals("Quantity(1000.0, GRAM)", q.convertTo(UC9.WeightUnit.GRAM).toString());
    }

    @Test
    void testAddition_KgPlusGram() {
        UC9.QuantityWeight q1 =
                new UC9.QuantityWeight(1.0, UC9.WeightUnit.KILOGRAM);

        UC9.QuantityWeight q2 =
                new UC9.QuantityWeight(1000.0, UC9.WeightUnit.GRAM);

        assertEquals("Quantity(2.0, KILOGRAM)", q1.add(q2).toString());
    }

    @Test
    void testAddition_TargetUnit() {
        UC9.QuantityWeight q1 =
                new UC9.QuantityWeight(1.0, UC9.WeightUnit.KILOGRAM);

        UC9.QuantityWeight q2 =
                new UC9.QuantityWeight(1000.0, UC9.WeightUnit.GRAM);

        assertEquals("Quantity(2000.0, GRAM)",
                q1.add(q2, UC9.WeightUnit.GRAM).toString());
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new UC9.QuantityWeight(1.0, null));
    }
}
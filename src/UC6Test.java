import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC6Test {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(2.0, UC6.LengthUnit.FEET);

        assertEquals("Quantity(3.0, FEET)", q1.add(q2).toString());
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(12.0, UC6.LengthUnit.INCH);

        assertEquals("Quantity(2.0, FEET)", q1.add(q2).toString());
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        UC6.Quantity q1 = new UC6.Quantity(12.0, UC6.LengthUnit.INCH);
        UC6.Quantity q2 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);

        assertEquals("Quantity(24.0, INCH)", q1.add(q2).toString());
    }

    @Test
    void testAddition_WithZero() {
        UC6.Quantity q1 = new UC6.Quantity(5.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(0.0, UC6.LengthUnit.INCH);

        assertEquals("Quantity(5.0, FEET)", q1.add(q2).toString());
    }

    @Test
    void testAddition_NegativeValues() {
        UC6.Quantity q1 = new UC6.Quantity(5.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(-2.0, UC6.LengthUnit.FEET);

        assertEquals("Quantity(3.0, FEET)", q1.add(q2).toString());
    }

    @Test
    void testAddition_Null() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}
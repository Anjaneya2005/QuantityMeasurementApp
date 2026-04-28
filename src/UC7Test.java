import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC7Test {

    @Test
    void testAddition_TargetUnit() {
        UC7.Quantity q1 = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity q2 = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        assertEquals("Quantity(24.0, INCH)", q1.add(q2, UC7.LengthUnit.INCH).toString());
    }

    @Test
    void testAddition_TargetFeet() {
        UC7.Quantity q1 = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity q2 = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        assertEquals("Quantity(2.0, FEET)", q1.add(q2, UC7.LengthUnit.FEET).toString());
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11Test {

    @Test
    void testVolumeEquality() {

        UC11.Quantity<UC11.VolumeUnit> v1 =
                new UC11.Quantity<>(1.0, UC11.VolumeUnit.LITRE);

        UC11.Quantity<UC11.VolumeUnit> v2 =
                new UC11.Quantity<>(1000.0, UC11.VolumeUnit.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testVolumeConversion() {

        UC11.Quantity<UC11.VolumeUnit> v =
                new UC11.Quantity<>(1.0, UC11.VolumeUnit.LITRE);

        assertEquals("Quantity(1000.0, MILLILITRE)",
                v.convertTo(UC11.VolumeUnit.MILLILITRE).toString());
    }

    @Test
    void testVolumeAddition_DefaultUnit() {

        UC11.Quantity<UC11.VolumeUnit> v1 =
                new UC11.Quantity<>(1.0, UC11.VolumeUnit.LITRE);

        UC11.Quantity<UC11.VolumeUnit> v2 =
                new UC11.Quantity<>(1000.0, UC11.VolumeUnit.MILLILITRE);

        assertEquals("Quantity(2.0, LITRE)",
                v1.add(v2).toString());
    }

    @Test
    void testVolumeAddition_TargetUnit() {

        UC11.Quantity<UC11.VolumeUnit> v1 =
                new UC11.Quantity<>(1.0, UC11.VolumeUnit.LITRE);

        UC11.Quantity<UC11.VolumeUnit> v2 =
                new UC11.Quantity<>(1000.0, UC11.VolumeUnit.MILLILITRE);

        assertEquals("Quantity(2000.0, MILLILITRE)",
                v1.add(v2, UC11.VolumeUnit.MILLILITRE).toString());
    }

    @Test
    void testVolumeDifferentValues() {

        UC11.Quantity<UC11.VolumeUnit> v1 =
                new UC11.Quantity<>(1.0, UC11.VolumeUnit.LITRE);

        UC11.Quantity<UC11.VolumeUnit> v2 =
                new UC11.Quantity<>(500.0, UC11.VolumeUnit.MILLILITRE);

        assertFalse(v1.equals(v2));
    }

    @Test
    void testVolumeNullUnit() {

        assertThrows(IllegalArgumentException.class,
                () -> new UC11.Quantity<>(1.0, null));
    }
}
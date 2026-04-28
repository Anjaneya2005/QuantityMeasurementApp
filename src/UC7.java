public class UC7 {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.393701 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double feet) {
            return feet / toFeet;
        }
    }

    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException();
            }
            this.value = value;
            this.unit = unit;
        }

        // 🔥 UC7 METHOD
        public Quantity add(Quantity other, LengthUnit targetUnit) {

            double v1 = this.unit.toFeet(this.value);
            double v2 = other.unit.toFeet(other.value);

            double sumFeet = v1 + v2;

            double result = targetUnit.fromFeet(sumFeet);

            return new Quantity(result, targetUnit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.add(q2, LengthUnit.INCH)); // 24 inches
    }
}
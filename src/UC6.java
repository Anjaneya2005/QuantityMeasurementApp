public class UC6 {

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

        public double fromFeet(double feetValue) {
            return feetValue / toFeet;
        }
    }

    // Quantity class
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        // 🔥 ADD METHOD (core of UC6)
        public Quantity add(Quantity other) {

            if (other == null) {
                throw new IllegalArgumentException("Other cannot be null");
            }

            // convert both to base unit (feet)
            double v1 = this.unit.toFeet(this.value);
            double v2 = other.unit.toFeet(other.value);

            double sumFeet = v1 + v2;

            // convert back to FIRST operand unit
            double result = this.unit.fromFeet(sumFeet);

            return new Quantity(result, this.unit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.add(q2)); // 2 feet
        System.out.println(q2.add(q1)); // 24 inches
    }
}
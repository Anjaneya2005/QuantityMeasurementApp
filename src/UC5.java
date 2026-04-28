public class UC5 {

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

    // 🔥 CORE METHOD (IMPORTANT)
    public static double convert(double value, LengthUnit from, LengthUnit to) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (from == null || to == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        // Step 1: convert to base (feet)
        double inFeet = from.toFeet(value);

        // Step 2: convert to target
        return to.fromFeet(inFeet);
    }

    public static void main(String[] args) {

        System.out.println(convert(1.0, LengthUnit.FEET, LengthUnit.INCH));   // 12
        System.out.println(convert(3.0, LengthUnit.YARD, LengthUnit.FEET));   // 9
        System.out.println(convert(36.0, LengthUnit.INCH, LengthUnit.YARD));  // 1
        System.out.println(convert(1.0, LengthUnit.CM, LengthUnit.INCH));     // ~0.393701
    }
}
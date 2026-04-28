public class UC9 {

    // 🔥 Weight Unit Enum (BASE = KILOGRAM)
    enum WeightUnit {
        KILOGRAM(1.0),
        GRAM(0.001),
        POUND(0.453592);

        private final double toKg;

        WeightUnit(double toKg) {
            this.toKg = toKg;
        }

        public double toBase(double value) {
            return value * toKg;
        }

        public double fromBase(double kg) {
            return kg / toKg;
        }
    }

    // 🔥 QuantityWeight Class
    static class QuantityWeight {
        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        // ✅ EQUALS
        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityWeight other = (QuantityWeight) obj;

            double v1 = unit.toBase(value);
            double v2 = other.unit.toBase(other.value);

            return Math.abs(v1 - v2) < 1e-6;
        }

        // ✅ CONVERSION
        public QuantityWeight convertTo(WeightUnit target) {

            double base = unit.toBase(value);
            double result = target.fromBase(base);

            return new QuantityWeight(result, target);
        }

        // ✅ ADD (default unit = first)
        public QuantityWeight add(QuantityWeight other) {

            double sum =
                    unit.toBase(value) +
                            other.unit.toBase(other.value);

            return new QuantityWeight(unit.fromBase(sum), unit);
        }

        // ✅ ADD (target unit)
        public QuantityWeight add(QuantityWeight other, WeightUnit target) {

            double sum =
                    unit.toBase(value) +
                            other.unit.toBase(other.value);

            return new QuantityWeight(target.fromBase(sum), target);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Equal: " + q1.equals(q2));

        System.out.println(q1.convertTo(WeightUnit.POUND));

        System.out.println(q1.add(q2));

        System.out.println(q1.add(q2, WeightUnit.GRAM));
    }
}
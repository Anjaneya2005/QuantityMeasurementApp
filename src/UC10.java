public class UC10 {

    // 🔥 INTERFACE
    interface IMeasurable {
        double toBase(double value);
        double fromBase(double base);
    }

    // 🔥 LENGTH UNIT
    enum LengthUnit implements IMeasurable {

        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.0328084);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double toBase(double value) {
            return value * factor;
        }

        public double fromBase(double base) {
            return base / factor;
        }
    }

    // 🔥 WEIGHT UNIT
    enum WeightUnit implements IMeasurable {

        KILOGRAM(1.0),
        GRAM(0.001),
        POUND(0.453592);

        private final double factor;

        WeightUnit(double factor) {
            this.factor = factor;
        }

        public double toBase(double value) {
            return value * factor;
        }

        public double fromBase(double base) {
            return base / factor;
        }
    }

    // 🔥 GENERIC CLASS
    static class Quantity<U extends IMeasurable> {

        private final double value;
        private final U unit;

        public Quantity(double value, U unit) {
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

            Quantity<?> other = (Quantity<?>) obj;

            // prevent mixing length & weight
            if (unit.getClass() != other.unit.getClass()) return false;

            double v1 = unit.toBase(value);
            double v2 = other.unit.toBase(other.value);

            return Math.abs(v1 - v2) < 1e-6;
        }

        // ✅ CONVERT
        public Quantity<U> convertTo(U target) {

            double base = unit.toBase(value);
            double result = target.fromBase(base);

            return new Quantity<>(result, target);
        }

        // ✅ ADD
        public Quantity<U> add(Quantity<U> other) {

            double sum =
                    unit.toBase(value) +
                            other.unit.toBase(other.value);

            return new Quantity<>(unit.fromBase(sum), unit);
        }

        // ✅ ADD WITH TARGET
        public Quantity<U> add(Quantity<U> other, U target) {

            double sum =
                    unit.toBase(value) +
                            other.unit.toBase(other.value);

            return new Quantity<>(target.fromBase(sum), target);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    // 🔥 MAIN
    public static void main(String[] args) {

        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCH);

        System.out.println("Length Equal: " + l1.equals(l2));

        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Equal: " + w1.equals(w2));

        System.out.println(l1.add(l2));
        System.out.println(w1.add(w2));
    }
}
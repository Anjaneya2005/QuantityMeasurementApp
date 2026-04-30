public class UC11 {

    // 🔥 INTERFACE
    interface IMeasurable {
        double toBase(double value);
        double fromBase(double base);
    }

    // 🔥 VOLUME UNIT
    enum VolumeUnit implements IMeasurable {

        LITRE(1.0),
        MILLILITRE(0.001);

        private final double factor;

        VolumeUnit(double factor) {
            this.factor = factor;
        }

        public double toBase(double value) {
            return value * factor;
        }

        public double fromBase(double base) {
            return base / factor;
        }
    }

    // 🔥 GENERIC QUANTITY CLASS
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

            // Prevent cross category (safe check)
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

    // 🔥 MAIN METHOD
    public static void main(String[] args) {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Equal: " + v1.equals(v2));

        System.out.println("Add (Litre): " + v1.add(v2));

        System.out.println("Add (ML): " + v1.add(v2, VolumeUnit.MILLILITRE));

        System.out.println("Convert: " + v1.convertTo(VolumeUnit.MILLILITRE));
    }
}
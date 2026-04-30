import java.util.*;
import java.util.stream.*;

public class UC12 {

    // 🔥 Bogie Class
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + "(" + capacity + ")";
        }
    }

    // 🔥 FILTER METHOD USING STREAM
    public static List<Bogie> filterHighCapacity(List<Bogie> bogies) {

        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    // 🔥 MAIN
    public static void main(String[] args) {

        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));

        List<Bogie> result = filterHighCapacity(list);

        System.out.println(result);
    }
}
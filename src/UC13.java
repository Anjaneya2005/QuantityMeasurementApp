import java.util.*;
import java.util.stream.*;

public class UC13 {

    // 🔥 Bogie Class
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // 🔥 LOOP FILTER
    public static List<Bogie> filterLoop(List<Bogie> list) {

        List<Bogie> result = new ArrayList<>();

        for (Bogie b : list) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // 🔥 STREAM FILTER
    public static List<Bogie> filterStream(List<Bogie> list) {

        return list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    // 🔥 MAIN
    public static void main(String[] args) {

        List<Bogie> list = new ArrayList<>();

        // create large dataset
        for (int i = 0; i < 100000; i++) {
            list.add(new Bogie("B" + i, i % 100));
        }

        // LOOP timing
        long start1 = System.nanoTime();
        List<Bogie> loopResult = filterLoop(list);
        long end1 = System.nanoTime();

        // STREAM timing
        long start2 = System.nanoTime();
        List<Bogie> streamResult = filterStream(list);
        long end2 = System.nanoTime();

        System.out.println("Loop Time: " + (end1 - start1));
        System.out.println("Stream Time: " + (end2 - start2));

        System.out.println("Loop size: " + loopResult.size());
        System.out.println("Stream size: " + streamResult.size());
    }
}
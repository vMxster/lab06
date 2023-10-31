package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MIN_RANGE = 1000;
    private static final int MAX_RANGE = 2000;
    private static final int ELEMS = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> list1 = new ArrayList<Integer>();
        int number = 1000;
        for (int i=0; i<MIN_RANGE ; i++) {
            list1.add(number);
            number++;
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> list2 = new LinkedList<Integer>(IntStream.range(MIN_RANGE, MAX_RANGE).boxed().toList());
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = list1.get(0);
        list1.set(0, list1.get(list1.size()-1));
        list1.set(list1.size()-1,temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final Integer num : list1) {
            System.out.println(num);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list1.add(0, i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Inserting "
                + list1.size()
                + " int in an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list2.add(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Inserting "
                + list2.size()
                + " int in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list1.get(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Reading "
                + list1.size()
                + " int in an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list2.get(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Reading "
                + list2.size()
                + " int in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Integer> map = new HashMap<String,Integer>(Map.of(   "Africa", 1110635000,
                                                                        "Americas", 972005000,
                                                                        "Antarctica", 0,
                                                                        "Asia", 4300000000,  // Overflow
                                                                        "Europe", 742452000,
                                                                        "Oceania", 38304000 ));
        /*
         * 8) Compute the population of the world
         */
        System.out.println(map);
    }
}

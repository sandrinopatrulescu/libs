package sandrinopatrulescu.collections;

import java.util.stream.Stream;

import static java.lang.Math.abs;

/**
 * <a href="https://github.com/BruceEckel/OnJava8-Examples/blob/master/onjava/Range.java">inspired by</a>
 */
public class Range {
    // Produce a sequence [start..end) incrementing by step
    // source: java range generator https://stackoverflow.com/a/36114723/17299754
    public static int[] range(int start, int end, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("step cannot be 0");
        }

        if ((end - start) * step < 0) {
            throw new IllegalArgumentException("monotony mismatch between interval and step");
        }

        return Stream.iterate(start, n -> n + step)
                .limit(abs((end - start) / step))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] range(int start, int end) {
        return range(start, end, end > start ? 1 : -1);
    }

    public static int[] range(int end) {
        return range(0, end);
    }
}

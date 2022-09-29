package sandrinopatrulescu.collections;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    // java generate random integer in range https://stackoverflow.com/a/363692/17299754
    public static final java.util.Random r = ThreadLocalRandom.current();


    public static int nextPositiveInt(int lowerInclusive, int upperExclusive) {
        return r.nextInt(upperExclusive) + lowerInclusive;
    }

    public static int nextInt(int minimum, int maximum) {
        // https://stackoverflow.com/a/27156435/17299754
        return r.ints(minimum, maximum + 1).findFirst().getAsInt();
    }
}

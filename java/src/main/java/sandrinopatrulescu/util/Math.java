package sandrinopatrulescu.util;

import static java.util.stream.LongStream.rangeClosed;

public class Math {
    public static boolean inRange(int value, int minimum, int maximum) {
        return value >= minimum && value <= maximum;
    }

    /** <a href="https://github.com/BruceEckel/OnJava8-Examples/blob/master/streams/Prime.java">inspired by</a> */
    public static boolean isPrime(int number) {
        return number >= 2 && rangeClosed(2, (long) java.lang.Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }
}

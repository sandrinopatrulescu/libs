package sandrinopatrulescu.collections;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

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

    public static String randomString(int length, char[] chars) {
        return r.ints(0, chars.length)
                .limit(length)
                .collect(StringBuilder::new, (sb, i) -> sb.append(chars[i]), StringBuilder::append)
                .toString();
    }

    public static String randomStringOfASCIIPrintableChars(int length) {
        int firstASCIIPrintableCharacter = 32;
        int lastASCIIPrintableCharacter = 126;

        return randomString(
                length,
                IntStream.range(firstASCIIPrintableCharacter, lastASCIIPrintableCharacter + 1)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString().
                        toCharArray()
        );
    }

    public static <T> T chooseFromArray(T[] array) {
        return array[r.nextInt(array.length)];
    }

    public static <T extends Enum<T>> T chooseFromEnum(T[] array) {
        return array[r.nextInt(array.length)];
    }
}

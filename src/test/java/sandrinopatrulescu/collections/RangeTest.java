package sandrinopatrulescu.collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static sandrinopatrulescu.collections.Range.range;

public class RangeTest {
    @Test
    public void whenStepIsZero_thenThrow() {
        assertThatThrownBy(() -> range(-10, 10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("step cannot be 0");
    }

    @Test
    public void whenMonotonyMismatchBetweenIntervalAndStep_thenThrow() {
        assertThatThrownBy(() -> range(1, 5, -2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("monotony mismatch between interval and step");

        assertThatThrownBy(() -> range(5, 1, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("monotony mismatch between interval and step");
    }

    @Test
    public void testRangeWithStartEndStep() {
        testRange(0, 10, 2);
        testRange(0, -10, -3);
        testRange(17, 20, 2);
        testRange(-24, -30, -2);
    }

    @Test
    public void testRange_withStartAndEnd() {
        assertThat(range(0, 10)).isEqualTo(range(0, 10, 1));
        assertThat(range(0, -10)).isEqualTo(range(0, -10, -1));
        assertThat(range(17, 20)).isEqualTo(range(17, 20, 1));
        assertThat(range(-24, -30)).isEqualTo(range(-24, -30, -1));
    }


    @Test
    public void testRange_withEnd() {
        assertThat(range(10)).isEqualTo(range(0, 10, 1));
        assertThat(range(-10)).isEqualTo(range(0, -10, -1));
        assertThat(range(3)).isEqualTo(range(0, 3, 1));
        assertThat(range(-3)).isEqualTo(range(0, -3, -1));
        assertThat(range(0)).isEqualTo(range(0, 0, 1));
        assertThat(range(-0)).isEqualTo(range(0, -0, -1));
        assertThat(range(1)).isEqualTo(range(0, 1, 1));
    }

    private void testRange(int start, int end, int step) {
        int current = start;
        int last = start;
        boolean isIncreasing = start < end;

        for (int i : range(start, end, step)) {
            assertThat(i).isEqualTo(current);
            last = current;
            current += step;
        }

        if (isIncreasing)
            assertThat(last).isLessThan(end);
        else
            assertThat(last).isGreaterThan(end);
    }
}

package org.socraagile.kata;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StatsCalculator {
    private final IntStream intStream;

    public StatsCalculator(int[] params) {

        intStream = Arrays.stream(params);
    }

    public OptionalInt min() {
        return intStream.min();
    }

    public OptionalInt max() {
        return intStream.max();
    }

    public long count() {
        return intStream.count();
    }
}

package org.socraagile.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;


public class StatsCalculatorShould {
    @DisplayName("Return the min value of a list of numbers")
    @ParameterizedTest(name = "{index} => min={0}")
    @CsvSource({
            "1, 1;2",
            "-2, 6;9;15;-2;92;11"
    })
    void return_min_value(int expected, String param) {
        int[] intList = convertStringToIntArray(param);

        StatsCalculator statsCalculator = new StatsCalculator(intList);

        OptionalInt result = statsCalculator.min();

        assertThat(result.getAsInt()).isEqualTo(expected);
    }

    @DisplayName("Return the max value of a list of numbers")
    @ParameterizedTest(name = "{index} => max={0}")
    @CsvSource({
            "2, 2;1",
            "92, 6;9;15;-2;92;11"
    })
    void return_max_value(int expected, String param) {
        int[] intList = convertStringToIntArray(param);

        StatsCalculator statsCalculator = new StatsCalculator(intList);

        OptionalInt result = statsCalculator.max();

        assertThat(result.getAsInt()).isEqualTo(expected);
    }

    @DisplayName("Return the numbers of elements")
    @ParameterizedTest(name = "{index} => size={0}")
    @CsvSource({
            "2, 2;1",
            "6, 6;9;15;-2;92;11"
    })
    void return_size_value(int expected, String param) {
        int[] intList = convertStringToIntArray(param);

        StatsCalculator statsCalculator = new StatsCalculator(intList);

        long result = statsCalculator.count();

        assertThat(result).isEqualTo(expected);
    }

    private int[] convertStringToIntArray(String param) {
        List<String> stringList = Arrays.asList(param.split(";"));
        int[] intList = stringList.stream()
                .mapToInt(num -> Integer.parseInt(num)).toArray();
        return intList;
    }

}

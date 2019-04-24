package com.yurwar;

import com.yurwar.exceptions.BusNumberFormatException;
import com.yurwar.exceptions.NumberOutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Input validator test")
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, 101})
    void expectExceptionOnExploitationTimeIntervalCheck(int argument) {
        Assertions.assertThrows(NumberOutOfRangeException.class, () -> InputValidator.checkExploitationTimeInterval(argument));
    }

    @ParameterizedTest
    @CsvSource({
            "-5",
            "0",
            "1001"
    })
    @ValueSource(ints = {-5, 0, 1001})
    void expectExceptionOnRouteNumberRangeCheck(int argument) {
        Assertions.assertThrows(NumberOutOfRangeException.class, () -> InputValidator.checkRouteNumberRange(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 10000001})
    void expectExceptionOnMileageRangeCheck(int argument) {
        Assertions.assertThrows(NumberOutOfRangeException.class, () -> InputValidator.checkMileageRange(argument));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "AA6464BB",
            "ac6464ac",
            "ac 6464ac",
            "ac6464 ac",
            "ac acac ac"})
    void expectExceptionOnBusNumberFormatCheck(String argument) {
        Assertions.assertThrows(BusNumberFormatException.class, () -> InputValidator.checkBusNumberFormat(argument));
    }
}

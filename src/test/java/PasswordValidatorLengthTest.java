import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PasswordValidatorLengthTest {

    @Test
    public void isPasswordLongEnough_withArrayLength7_returnsFalse() {
        //GIVEN
        char[] password = {'o', '2', '3', 'l', 'p', '-', 'q'};

        // WHEN
        boolean actual = PasswordValidator.isPasswordLongEnough(password);
        //THEN
        Assertions.assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("shortPasswordsProvider")
    public void passwordIsLongEnough_withShortPassword_ReturnsFalse(boolean expected,
                                                              char[] inputPassword) {
        boolean actual = PasswordValidator.isPasswordLongEnough(inputPassword);
        Assertions.assertFalse(actual);
    }

    private static Stream<Arguments> shortPasswordsProvider() {
        return Stream.of(
                Arguments.of(false, new char[]{'o', '2', '3'}),
                Arguments.of(false, new char[]{}),
                Arguments.of(false, new char[]{'z', '9', '0', '-', '*', 'e', 'r'})

        );
    }

    @ParameterizedTest
    @MethodSource("longPasswordsProvider")
    public void passwordIsLongEnough_withLongPassword_ReturnsTrue(boolean expected,
                                                             char[] inputPassword) {
        boolean actual = PasswordValidator.isPasswordLongEnough(inputPassword);
        Assertions.assertTrue(actual);
    }


    private static Stream<Arguments> longPasswordsProvider() {
        return Stream.of(
                Arguments.of(true, new char[]{'o', '2', '3', '5', 'w', 'f', '+', 'o'}),
                Arguments.of(true, new char[]{'z', '9', '0', '-', '*', 'e', 'r', '^', 'a'})

        );
    }


}

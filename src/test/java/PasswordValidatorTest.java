import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PasswordValidatorTest {

    @Test
    public void returnFalse_whenPasswordLongEnough_WithArrayLength7() {
        //GIVEN
        char[] password = {'o', '2', '3', 'l', 'p', '-', 'q'};

        // WHEN
        boolean actual = PasswordValidator.isPasswordLongEnough(password);
        //THEN
        Assertions.assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("passwordsProviderWhenFalse")
    public void parameterizedTest_whenPasswordLongEnoughFalse(boolean expected,
                                                              char[] inputPassword) {
        boolean actual = PasswordValidator.isPasswordLongEnough(inputPassword);
        Assertions.assertFalse(actual);
    }

    private static Stream<Arguments> passwordsProviderWhenFalse() {
        return Stream.of(
                Arguments.of(false, new char[]{'o', '2', '3'}),
                Arguments.of(false, new char[]{}),
                Arguments.of(false, new char[]{'z', '9', '0', '-', '*', 'e', 'r'})

        );
    }

    @ParameterizedTest
    @MethodSource("passwordsProviderWhenTrue")
    public void parameterizedTest_whenPasswordLongEnoughTrue(boolean expected,
                                                             char[] inputPassword) {
        boolean actual = PasswordValidator.isPasswordLongEnough(inputPassword);
        Assertions.assertTrue(actual);
    }


    private static Stream<Arguments> passwordsProviderWhenTrue() {
        return Stream.of(
                Arguments.of(true, new char[]{'o', '2', '3', '5', 'w', 'f', '+', 'o'}),
                Arguments.of(true, new char[]{'z', '9', '0', '-', '*', 'e', 'r', '^', 'a'})

        );
    }
}

import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PasswordValidatorDigitsTest {
    @Test
    public void passwordHasDigits_withB1_ReturnsTrue() {
        //GIVEN
        char[] input = {'B', '1'};
        //WHEN
        boolean actual = PasswordValidator.passwordHasDigits(input);
        //THEN
        Assertions.assertTrue(actual);

    }

    @ParameterizedTest
    @MethodSource("passwordWithDigitsProvider")
    public void passwordHasDigits_withDigitPassword_ReturnsTrue(char[] password) {
        Assertions.assertTrue(PasswordValidator.passwordHasDigits(password));

    }

    private static Stream<Arguments> passwordWithDigitsProvider() {
        return Stream.of(
                Arguments.of(new char[]{'1', 'a'}),
                Arguments.of(new char[] {'a','f','2'}),
                Arguments.of(new char[] {'-','9','a','2'})
        );
    }

    @ParameterizedTest
    @MethodSource("passwordWithoutDigitsProvider")
    public void passwordHasDigits_withoutDigitPassword_ReturnsFalse(char[] password) {
        Assertions.assertFalse(PasswordValidator.passwordHasDigits(password));

    }

    private static Stream<Arguments> passwordWithoutDigitsProvider() {
        return Stream.of(
                Arguments.of(new char[]{'v', 'a'}),
                Arguments.of(new char[] {'a','b','*'}),
                Arguments.of(new char[] {'-','x','a','q'}),
                Arguments.of(new char[] {})
        );
    }
}

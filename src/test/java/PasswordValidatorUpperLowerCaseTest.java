import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PasswordValidatorUpperLowerCaseTest {

    @Test
    public void isPasswordWithUpperAndLowerCase_withAl_ReturnsTrue() {
        //GIVEN
        char[] password = {'A', 'l'};
        //WHEN
        boolean actual = PasswordValidator.isPasswordWithUpperAndLowerCase(password);
        //THEN
        Assertions.assertTrue(actual);
    }
    @Test
    public void isPasswordWithUpperAndLowerCase_withEmptyArray_ReturnsFalse() {
        //GIVEN
        char[] password = {};
        //WHEN
        boolean actual = PasswordValidator.isPasswordWithUpperAndLowerCase(password);
        //THEN
        Assertions.assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("passwordsOnlyWithLowerCaseProvider")
    public void isPasswordWithUpperAndLowerCase_withLowerCasePasswords_ReturnsFalse(char[] password) {
        boolean actual = PasswordValidator.isPasswordWithUpperAndLowerCase(password);
        Assertions.assertFalse(actual);
    }

    private static Stream<Arguments> passwordsOnlyWithLowerCaseProvider() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'b', 'd', 'q'}),
                Arguments.of(new char[]{'d', 'a'}),
                Arguments.of(new char[]{'x', 'z',}),
                Arguments.of(new char[]{'a'})
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsOnlyWithUpperCaseProvider")
    public void isPasswordWithUpperAndLowerCase_withUpperCasePasswords_ReturnsFalse(char[] password) {
        boolean actual = PasswordValidator.isPasswordWithUpperAndLowerCase(password);
        Assertions.assertFalse(actual);
    }

    private static Stream<Arguments> passwordsOnlyWithUpperCaseProvider() {
        return Stream.of(
                Arguments.of(new char[]{'X', 'C', 'P', 'A'}),
                Arguments.of(new char[]{'P', 'D'}),
                Arguments.of(new char[]{'T', 'U',}),
                Arguments.of(new char[]{'C'})
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsWithLowerUpperCaseProvider")
    public void isPasswordWithUpperAndLowerCase_withUpperAndLowerCasePasswords_ReturnsTrue(char[] password) {
        boolean actual = PasswordValidator.isPasswordWithUpperAndLowerCase(password);
        Assertions.assertTrue(actual);
    }

    private static Stream<Arguments> passwordsWithLowerUpperCaseProvider() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'B', 'd', 'E'}),
                Arguments.of(new char[]{'d', 'D'}),
                Arguments.of(new char[]{'x', 'z','O'}),
                Arguments.of(new char[]{'a','X','P','Ü'})
        );
    }
}

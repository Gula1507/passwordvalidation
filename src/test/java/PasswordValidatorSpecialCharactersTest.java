import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PasswordValidatorSpecialCharactersTest {

    @ParameterizedTest
    @MethodSource("passwordsWithSpecialCharactersProvider")
    public void hasPasswordSpecialCharacters_whenPassWithCharacters_returnTrue(char[] password) {
        boolean actual = PasswordValidator.hasPasswordSpecialCharacters(password);
        Assertions.assertTrue(actual);
    }

    private static Stream<Arguments> passwordsWithSpecialCharactersProvider() {
        return Stream.of(
                Arguments.of(new char[]{'-', 'a', 'b', '*', '8'}),
                Arguments.of(new char[]{'o', '1', '^'}),
                Arguments.of(new char[]{'?'}),
                Arguments.of(new char[]{'1', '2', '8', '0', '.'})

        );
    }

    @ParameterizedTest
    @MethodSource("passwordsWithoutSpecialCharactersProvider")
    public void hasPasswordSpecialCharacters_whenPassWithoutCharacters_returnFalse(char[] password) {
        boolean actual = PasswordValidator.hasPasswordSpecialCharacters(password);
        Assertions.assertFalse(actual);
    }

    private static Stream<Arguments> passwordsWithoutSpecialCharactersProvider() {
        return Stream.of(
                Arguments.of(new char[]{'7', 'a', 'b', 'e', '8'}),
                Arguments.of(new char[]{'o', '1', ' '}),
                Arguments.of(new char[]{'a'}),
                Arguments.of(new char[]{'1', '2', '8', '0', '7'})

        );
    }

}

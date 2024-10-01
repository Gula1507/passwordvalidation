import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PasswordValidatorDigitsTest {
    @Test
    public void returnTrue_whenPasswordHasDigits_withB1 () {
        //GIVEN
        char[] input={'B','1'};
        //WHEN
        boolean actual= PasswordValidator.passwordHasDigits(input);
        //THEN
        Assertions.assertTrue(actual);

    }

//    @ParameterizedTest
//    @MethodSource("passwordWithDigitsProvider")
//    public void parameterized_
}

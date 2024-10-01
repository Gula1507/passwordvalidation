import de.neuefische.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidatorCommonlyUsedTest {
    @Test
    public void passwordIsCommonUsed_withAa345678_ReturnsTrue() {
        //GIVEN
        char[] input = {'A', 'a','3','4','5','6','7','8'};
        //WHEN
        boolean actual = PasswordValidator.isPasswordCommonlyUsed(input);
        //THEN
        Assertions.assertTrue(actual);
    }
    @Test
    public void passwordIsCommonUsed_withPassword1_ReturnsTrue() {
        //GIVEN
        char[] input = {'P', 'a','s','s','w','o','r','d','1'};
        //WHEN
        boolean actual = PasswordValidator.isPasswordCommonlyUsed(input);
        //THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void passwordIsCommonUsed_withSkz0tira1_ReturnsFalse() {
        //GIVEN
        char[] input = {'S', 'k','z','0','t','i','r','a','1'};
        //WHEN
        boolean actual = PasswordValidator.isPasswordCommonlyUsed(input);
        //THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void passwordIsCommonUsed_withEmptyArray_ReturnsFalse() {
        //GIVEN
        char[] input = {};
        //WHEN
        boolean actual = PasswordValidator.isPasswordCommonlyUsed(input);
        //THEN
        Assertions.assertFalse(actual);
    }
}

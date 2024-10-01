package de.neuefische;

public class PasswordValidator {
    public static boolean isPasswordLongEnough(char[] password) {
        return password.length >= 8;
    }

    public static boolean passwordHasDigits(char[] password) {
        for (char symbol : password) {
            if (Character.isDigit(symbol)) {
                return true;
            }

        }
        return false;
    }
//    public static boolean isPasswordWithUpperAndLowerCase (char[] password)
//    public static boolean isPasswordInCommonUse (char[] password)
}

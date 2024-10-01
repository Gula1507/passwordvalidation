package de.neuefische;

import java.io.*;
import java.util.Arrays;



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

    public static boolean isPasswordWithUpperAndLowerCase(char[] password) {
        int counterLowerCase = 0;
        int counterUpperCase = 0;
        for (char symbol : password) {
            if (Character.isLowerCase(symbol)) {
                counterLowerCase++;
            } else if (Character.isUpperCase(symbol)) {
                counterUpperCase++;

            }
        }
        return counterLowerCase > 0 && counterUpperCase > 0;
    }

    public static boolean isPasswordCommonlyUsed(char[] password) {

        try (InputStream inputStream = PasswordValidator.class.getResourceAsStream("/common_passwords.txt");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String commonPassword;
            while ((commonPassword = bufferedReader.readLine()) != null) {
                char[] commonPasswordCharArray = commonPassword.toCharArray();
                if (Arrays.equals(commonPasswordCharArray, password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading common passwords file", e);
        }
        return false;
    }
}

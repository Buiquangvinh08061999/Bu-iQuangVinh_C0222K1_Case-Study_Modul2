package vn.vb.accessory.shop.utils;
import java.util.regex.Pattern;
public class ValidateUtils {
    private static final String USERNAME_PATTERN = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private static final String PASSWORD_PATTERN = "^([a-zA-Z0-9]{8,})";
    private static final String NAME_PATTERN = "^([A-Z]+[a-z]*[ ]?)+$";
    private static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";

    public static boolean isUsernameValid(String userName){
        return Pattern.compile(USERNAME_PATTERN).matcher(userName).matches();
    }

    public static boolean isPasswordValid(String password){
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }

    public static boolean isNameValid(String name){
        return Pattern.compile(NAME_PATTERN).matcher(name).matches();
    }

    public static boolean isPhoneValid(String phone){
        return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
    }

    public static boolean isEmailValid(String email){
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }
}

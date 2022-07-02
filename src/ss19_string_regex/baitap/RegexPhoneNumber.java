package ss19_string_regex.baitap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPhoneNumber {
    private static final String PHONE_REGEX = "^(84-0)\\d{9}$";

    public RegexPhoneNumber() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

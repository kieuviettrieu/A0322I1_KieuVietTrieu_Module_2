package ss19_string_regex.baitap;

public class PhoneNumberTest {

    public static final String[] PhoneNumbers = new String[] { "84-0978489648", "84-5978489648", "74-0978489648"};

    public static void main(String[] args) {
        RegexPhoneNumber regex=new RegexPhoneNumber();
        for (String string: PhoneNumbers)
        {
            System.out.println("Phone number "+string+" is "+regex.validate(string));
        }
    }
}

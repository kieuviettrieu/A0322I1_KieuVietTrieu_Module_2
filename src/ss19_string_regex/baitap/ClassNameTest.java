package ss19_string_regex.baitap;

public class ClassNameTest {
    public static final String[] className = new String[] { "C0318G", "M0318G", "P0323A"};

    public static void main(String[] args) {
        RegexClassName regexClassName=new RegexClassName();
        for (String string:className)
        {
            System.out.println("Class name "+string+" is "+regexClassName.validate(string));
        }
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class txt {
    public static void main(String[] args) {
        Date date=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        try {
            date=simpleDateFormat.parse("22/12/2019");
            System.out.println(simpleDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

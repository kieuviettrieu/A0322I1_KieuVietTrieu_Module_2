package ss19_string_regex.baitap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawJava {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://didongviet.vn/dchannel/nhac-tiktok-hot-nhat-hien-nay/#14_Thi_Thoi_Nal_ft_Tvk");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("<a href=(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                String string=m.group(1);
                int index=string.indexOf("\">");
                if(index!=-1 && string.length()>5)
                {
                    String string1=string.substring(index+2);
                    if((string1.charAt(0)=='1' || string1.charAt(0)=='2') && string1.charAt(1)=='.')
                    {
                        System.out.println(string1);
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

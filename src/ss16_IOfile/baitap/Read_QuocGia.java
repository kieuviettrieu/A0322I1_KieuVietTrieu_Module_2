package ss16_IOfile.baitap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class Read_QuocGia {
    public static void main(String[] args) {
        ArrayList<QuocGia> quocGias=readFile("D:\\Codegym\\module2\\src\\ss16_IOfile\\baitap\\quocgia.txt");
        for (QuocGia quocGia:quocGias)
        {
            System.out.println(quocGia.toString());
        }

    }

    public static ArrayList<QuocGia> readFile(String filePath){
        ArrayList<QuocGia> quocGias = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] strings=line.split(",");
                int id=Integer.parseInt(strings[0]);
                String code=strings[1];
                String name=strings[2];
                quocGias.add(new QuocGia(id,code,name));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return quocGias;
    }
}

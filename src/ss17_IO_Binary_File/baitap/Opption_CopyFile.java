package ss17_IO_Binary_File.baitap;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Opption_CopyFile {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Opption_CopyFile copyFile=new Opption_CopyFile();
        System.out.print("Nhập đường dẫn nguồn: ");
        String path1=scanner.nextLine();
        System.out.print("Nhập đường dẫn đến đích: ");
        String path2=scanner.nextLine();

        copyFile.copyFile(path1,path2);
    }

    private ArrayList<Character> readFileText(String filePath) {
        ArrayList<Character> arrayList=new ArrayList<>();
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            InputStream ir=new FileInputStream(file);
            int line;
            int sum = 0;
            while ((line = ir.read()) != -1) {
                arrayList.add((char) line);
            }
            ir.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return arrayList;
    }

    private void writeFile(String filePath, ArrayList<Character> arrayList){
        try {
            File file = new File(filePath);
            OutputStream outputStream=new FileOutputStream(file);
            for (Character character:arrayList)
            {
                outputStream.write(character);
            }
            outputStream.close();
            System.out.println("Số byte trong tệp là: "+arrayList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String filePath1,String filePath2)
    {
        writeFile(filePath2,readFileText(filePath1));
    }
}

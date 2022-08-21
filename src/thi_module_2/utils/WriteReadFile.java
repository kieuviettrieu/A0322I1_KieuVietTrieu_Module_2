package thi_module_2.utils;

import CaseStudy.models.facitily.Facility;
import CaseStudy.models.facitily.Room;
import thi_module_2.models.SanPham;
import thi_module_2.models.SanPhamNhapKhau;
import thi_module_2.models.SanPhamXuatKhau;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class WriteReadFile {
    public static void writeToFile(String path, ArrayList<SanPhamNhapKhau> sanPhamNhapKhau) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (SanPhamNhapKhau sanPham:sanPhamNhapKhau) {
                br.write(sanPham.toStringWrite());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void writeToFiles(String path, ArrayList<SanPhamXuatKhau> sanPhamXuatKhaus) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (SanPhamXuatKhau sanPham:sanPhamXuatKhaus) {
                br.write(sanPham.toStringWrite());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void readDataFromFileRoom(String path, Map<Room,Integer> map) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            map.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                String idDichVu=strings[0];
                int id= Integer.parseInt(strings[0].substring(5,9));
                String tenDichVu=strings[1];
                double dienTich= Double.parseDouble(strings[2]);
                int chiPhi= Integer.parseInt(strings[3]);
                int maxPerson= Integer.parseInt(strings[4]);
                String kieuThue=strings[5];
                String dichVuFree=strings[6];
                int value= Integer.parseInt(strings[7]);
                Room room=new Room(idDichVu,tenDichVu,dienTich,chiPhi,maxPerson,kieuThue,dichVuFree);
                map.put(room,value);
                if(Facility.getId()<id)
                {
                    Facility.setId(id);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }
}

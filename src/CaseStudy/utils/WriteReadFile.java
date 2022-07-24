package CaseStudy.utils;

import CaseStudy.models.*;
import CaseStudy.models.facitily.Facility;
import CaseStudy.models.facitily.House;
import CaseStudy.models.facitily.Room;
import CaseStudy.models.facitily.Villa;
import CaseStudy.models.person.Customer;
import CaseStudy.models.person.Employee;
import CaseStudy.models.person.Person;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class WriteReadFile {
    public static final String FILE_EMPLOYEE="D:\\Codegym\\module2\\src\\CaseStudy\\data\\employee.cvs";
    public static final String FILE_CUSTOMER="D:\\Codegym\\module2\\src\\CaseStudy\\data\\customer.cvs";
    public static final String FILE_VILLA="D:\\Codegym\\module2\\src\\CaseStudy\\data\\villa.cvs";
    public static final String FILE_HOUSE="D:\\Codegym\\module2\\src\\CaseStudy\\data\\house.cvs";
    public static final String FILE_ROOM="D:\\Codegym\\module2\\src\\CaseStudy\\data\\room.cvs";
    public static final String FILE_FACILITYMAINTEDID="D:\\Codegym\\module2\\src\\CaseStudy\\data\\facilityid.cvs";
    public static final String FILE_BOOKING="D:\\Codegym\\module2\\src\\CaseStudy\\data\\booking.cvs";
    public static final String FILE_CONTRACT="D:\\Codegym\\module2\\src\\CaseStudy\\data\\contract.cvs";
    public static final String FILE_VOUCHER="D:\\Codegym\\module2\\src\\CaseStudy\\data\\voucher.cvs";

    public static void writeToFile(String path, List<? extends Person> listObject) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (int i = 0; i < listObject.size(); i++) {
                br.write(listObject.get(i).toString());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void writeToFile(String path,Set<String> set) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (String string:set) {
                br.write(string);
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void writeToFile(String path, Map<Integer,Integer> map) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (Map.Entry<Integer,Integer> entry:map.entrySet())
            {
                br.write(entry.getKey()+";"+entry.getValue());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }



    public static void writeToBooking(String path, TreeSet<Booking> listObject) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (Booking booking:listObject) {
                br.write(booking.toString());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void writeToContract(String path, TreeSet<Contract> listObject) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (Contract contract:listObject) {
                br.write(contract.toString());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void writeToFileFacility(String path, Map<? extends Facility,Integer> listObject) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (Map.Entry<? extends Facility,Integer> entry:listObject.entrySet()) {
                br.write(entry.getKey().toString()+";"+entry.getValue());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("File recording failed!");
        }
    }

    public static void readDataFromFileEmp(String path, List<Employee> list) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            list.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                int id=Integer.parseInt(strings[0]);
                String trinhDo=strings[1];
                String viTri=strings[2];
                double luong= Double.parseDouble(strings[3]);
                String hoten=strings[4];
                Date ngaySinh= DateException.simpleDateFormat.parse(strings[5]);
                String set=strings[6];
                String sdt=strings[7];
                String email=strings[8];
                String cccd=strings[9];
                Employee employee = new Employee(hoten,ngaySinh,set,sdt,email,cccd,id,trinhDo,viTri,luong);
                list.add(employee);
            }
            br.close();
            fr.close();
        } catch (IOException | ParseException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public static void readDataFromFileCus(String path, List<Customer> list) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            list.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                int id=Integer.parseInt(strings[0]);
                String loaiKhach=strings[1];
                String diaChi=strings[2];
                String hoten=strings[3];
                Date ngaySinh= DateException.simpleDateFormat.parse(strings[4]);
                String set=strings[5];
                String sdt=strings[6];
                String email=strings[7];
                String cccd=strings[8];
                Customer customer=new Customer(id,hoten,ngaySinh,set,sdt,email,cccd,loaiKhach,diaChi);
                list.add(customer);
            }
            br.close();
            fr.close();
        } catch (IOException | ParseException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }


    public static void readDataFromFileVilla(String path, Map<Villa,Integer> map) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            map.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                String idDichVu=strings[0];
                int id= Integer.parseInt(strings[0].substring(5,9));
                String tenDichVu=strings[1];
                double dienTichHoBoi= Double.parseDouble(strings[2]);
                int soTang= Integer.parseInt(strings[3]);
                String tieuChuanPhong=strings[4];
                double dienTich= Double.parseDouble(strings[5]);
                int chiPhi= Integer.parseInt(strings[6]);
                int maxPerson= Integer.parseInt(strings[7]);
                String kieuThue=strings[8];
                Villa villa=new Villa(idDichVu,tenDichVu,dienTich,chiPhi,maxPerson,kieuThue,tieuChuanPhong,dienTichHoBoi,soTang);
                int value= Integer.parseInt(strings[9]);
                map.put(villa,value);if(Facility.getId()<id)
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

    public static void readDataFromFileHouse(String path, Map<House,Integer> map) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            map.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                String idDichVu=strings[0];
                int id= Integer.parseInt(strings[0].substring(5,9));
                String tenDichVu=strings[1];
                int soTang= Integer.parseInt(strings[2]);
                String tieuChuanPhong=strings[3];
                double dienTich= Double.parseDouble(strings[4]);
                int chiPhi= Integer.parseInt(strings[5]);
                int maxPerson= Integer.parseInt(strings[6]);
                String kieuThue=strings[7];
                House house=new House(idDichVu,tenDichVu,dienTich,chiPhi,maxPerson,kieuThue,tieuChuanPhong,soTang);
                int value= Integer.parseInt(strings[8]);
                map.put(house,value);
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

    public static void readDataFromFileRoom(String path, Map<Room,Integer> map) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            map.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
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

    public static void readDataFromFileBook(String path, TreeSet<Booking> list) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            list.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                int maBooking= Integer.parseInt(strings[0]);
                Date firtDate=DateException.simpleDateFormat.parse(strings[1]);
                Date lastDate=DateException.simpleDateFormat.parse(strings[2]);
                int maKhachHang= Integer.parseInt(strings[3]);
                String tenDichVu=strings[4];
                String loaiDichVu=strings[5];
                Booking booking=new Booking(maBooking,firtDate,lastDate,maKhachHang,tenDichVu,loaiDichVu);
                list.add(booking);
            }
            br.close();
            fr.close();
        } catch (IOException | ParseException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public static void readDataFromFileContract(String path, TreeSet<Contract> list) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            list.clear();
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(";");
                int soHopDong=Integer.parseInt(strings[0]);
                int maBooking=Integer.parseInt(strings[1]);
                double tienCoc=Double.parseDouble(strings[2]);
                double tienThanhToan=Double.parseDouble(strings[3]);
                int maKhachHang=Integer.parseInt(strings[4]);
                Contract contract=new Contract(soHopDong,maBooking,tienCoc,tienThanhToan,maKhachHang);
                list.add(contract);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public static void readDataFromFileID(String path, Set<String> set) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            set.clear();
            while ((line = br.readLine()) != null) {
                set.add(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public static void readDataFromVoucher(String path, Map<Integer,Integer> map) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            map.clear();
            while ((line = br.readLine()) != null) {
                String[] strings=line.split(";");
                int id= Integer.parseInt(strings[0]);
                int voucher=Integer.parseInt(strings[1]);
                map.put(id,voucher);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

}

package CaseStudy.services.Impl;

import CaseStudy.models.facitily.Facility;
import CaseStudy.models.facitily.House;
import CaseStudy.models.facitily.Room;
import CaseStudy.models.facitily.Villa;
import CaseStudy.services.Interface.FacilityService;
import CaseStudy.utils.MatchesCheck;
import CaseStudy.utils.WriteReadFile;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private static String[] arayKieuThue={"","Year","Month","Day","Hour"};
    private static Set<String> mapMainteID=new TreeSet<>();
    private static Map<Villa,Integer> mapVilla=new LinkedHashMap<>();
    private static Map<House,Integer> mapHouse=new LinkedHashMap<>();
    private static Map<Room,Integer> mapRoom=new LinkedHashMap<>();

    @Override
    public void disPlayFMaintenance() {
        int dem=0;
        System.out.println("List of rooms in need of maintenance: ");
        if(mapMainteID.size()!=0) {
            for (String id:mapMainteID)
            {
                Facility facility=FacilityServiceImpl.searchFacility(id);
                if(facility instanceof Villa)
                {
                    Villa villa=(Villa) facility;
                    System.out.println(villa.toInfomation());
                }
                else
                if(facility instanceof House)
                {
                    House house=(House) facility;
                    System.out.println(house.toInfomation());
                }
                else
                if(facility instanceof Room)
                {
                    Room room=(Room) facility;
                    System.out.println(room.toInfomation());;
                }

            }
        }
        if(dem==0)
        {
            System.out.println("Empty list!");
        }
    }

    @Override
    public void addNew(Facility facility) {
        if(facility!=null)
        {
            if(facility instanceof Villa)
            {
                mapVilla.put((Villa) facility,0);
                WriteReadFile.writeToFileFacility(WriteReadFile.FILE_VILLA,mapVilla);
            }
            else
            if(facility instanceof House)
            {
                mapHouse.put((House)facility,0);
                WriteReadFile.writeToFileFacility(WriteReadFile.FILE_HOUSE,mapHouse);
            }
            else
            {
                mapRoom.put((Room)facility,0);
                WriteReadFile.writeToFileFacility(WriteReadFile.FILE_ROOM,mapRoom);
            }
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
    }

    @Override
    public void disPlay() {
        System.out.println("List of facility: ");
        if(mapVilla.size()!=0 || mapHouse.size()!=0 || mapRoom.size()!=0) {
            for (Map.Entry<Villa,Integer> villaIntegerEntry:mapVilla.entrySet())
            {
                System.out.println(villaIntegerEntry.getKey().toInfomation()+", Number of uses: "+villaIntegerEntry.getValue());
            }

            for (Map.Entry<House,Integer> houseIntegerEntry:mapHouse.entrySet())
            {
                System.out.println(houseIntegerEntry.getKey().toInfomation()+", Number of uses: "+houseIntegerEntry.getValue());
            }

            for (Map.Entry<Room,Integer> roomIntegerEntry:mapRoom.entrySet())
            {
                System.out.println(roomIntegerEntry.getKey().toInfomation()+", Number of uses: "+roomIntegerEntry.getValue());
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public void disPlay(String tenDichvu)
    {
        System.out.println("List of facility: ");
        if(tenDichvu.equalsIgnoreCase("Villa")) {
            for (Map.Entry<Villa,Integer> villaIntegerEntry:mapVilla.entrySet())
            {
                System.out.println(villaIntegerEntry.getKey().toInfomation()+", Number of uses: "+villaIntegerEntry.getValue());
            }
        }
        else
            if(tenDichvu.equalsIgnoreCase("House"))
            {
                for (Map.Entry<House,Integer> houseIntegerEntry:mapHouse.entrySet())
                {
                    System.out.println(houseIntegerEntry.getKey().toInfomation()+", Number of uses: "+houseIntegerEntry.getValue());
                }
            }
            else
                if(tenDichvu.equalsIgnoreCase("Room"))
                {
                    for (Map.Entry<Room,Integer> roomIntegerEntry:mapRoom.entrySet())
                    {
                        System.out.println(roomIntegerEntry.getKey().toInfomation()+", Number of uses: "+roomIntegerEntry.getValue());
                    }
                }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public boolean isFacility(String tenDichVu)
    {
        if(tenDichVu.equalsIgnoreCase("Villa"))
            return !mapVilla.isEmpty();
        if(tenDichVu.equalsIgnoreCase("House"))
            return !mapHouse.isEmpty();
        if(tenDichVu.equalsIgnoreCase("Room"))
            return !mapRoom.isEmpty();
        return false;
    }

    public Facility returnFacility()
    {
        System.out.println("Enter Information: ");
        Facility facility;
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.Villa");
        System.out.println("2.Room");
        System.out.println("3.House");
        System.out.println("0.Back to menu");
        System.out.print("Choose a room type: ");
        String name="";
        int choose=-1;
        while (!(choose>=0 && choose<=3))
        {
            String chooseStr=scanner.nextLine();
            if(MatchesCheck.checkOneNumber(chooseStr))
                choose=Integer.parseInt(chooseStr);
            else
                System.out.println("Please choose again!");
        }
        if(choose==0)
        {
            return null;
        }
        System.out.print("Area of the room to rent: ");
        double area=Double.parseDouble(scanner.nextLine());
        while (area<=30)
        {
            System.out.println("Room area > 30m^2");
            System.out.print("Room area: ");
            area=Double.parseDouble(scanner.nextLine());
        }
        System.out.print("Rental costs: ");
        int cost=Integer.parseInt(scanner.nextLine());
        while (cost<=0)
        {
            System.out.println("Cost > 0");
            System.out.print("Rental costs: ");
            cost=Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Maximum number of people: ");
        int maxPerson=Integer.parseInt(scanner.nextLine());
        while (!(maxPerson>0 && maxPerson<20))
        {
            System.out.println("Maximum>0 and Maximum<20");
            System.out.print("Maximum number of people: ");
            maxPerson=Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Choose a rental type: ");
        System.out.println("1.Rent by year");
        System.out.println("2.Rent by month");
        System.out.println("3.Rent by day");
        System.out.println("4.Rent by hour");
        System.out.print("Choose: ");
        int kieu=Integer.parseInt(scanner.nextLine());
        if(!(kieu<=4 && kieu>=1))
        {
            kieu=3;
        }
        String kieuThue=arayKieuThue[kieu];
        switch (choose)
        {
            case 1:
                name="Villa";
                System.out.print("Room standard: ");
                String tieuChuanVilla=scanner.nextLine();
                System.out.print("Pool area: ");
                double areaHoBoi=Double.parseDouble(scanner.nextLine());
                while (areaHoBoi<=30)
                {
                    System.out.println("Pool area > 30m^2");
                    System.out.print("Pool area: ");
                    areaHoBoi=Double.parseDouble(scanner.nextLine());
                }
                System.out.print("Number of floors: ");
                int soTangVilla=Integer.parseInt(scanner.nextLine());
                while (soTangVilla<0)
                {
                    System.out.println("Number of floors > 0");
                    System.out.print("Number of floors: ");
                    soTangVilla=Integer.parseInt(scanner.nextLine());
                }
                facility=new Villa(name,area,cost,maxPerson,kieuThue,tieuChuanVilla,areaHoBoi,soTangVilla);
                break;
            case 2:
                name="Room";
                System.out.print("Free service: ");
                String dichVuFree=scanner.nextLine();
                facility=new Room(name,area,cost,maxPerson,kieuThue,dichVuFree);
                break;
            case 3:
                name="House";
                System.out.print("Room standard: ");
                String tieuChuanHouse=scanner.nextLine();
                System.out.print("Number of floors: ");
                int soTangHouse=Integer.parseInt(scanner.nextLine());
                while (soTangHouse<=0)
                {
                    System.out.println("Number of floors > 0");
                    System.out.print("Number of floors: ");
                    soTangHouse=Integer.parseInt(scanner.nextLine());
                }
                facility=new House(name,area,cost,maxPerson,kieuThue,tieuChuanHouse,soTangHouse);
                break;
            default:
                facility=null;
        }
        return facility;
    }

    public static Facility searchFacility(String id)
    {
        String maID=id.substring(0,4);

        if(maID.equalsIgnoreCase("SVVL"))
        {
            for (Map.Entry<Villa,Integer> villaIntegerEntry:mapVilla.entrySet())
            {
                if(villaIntegerEntry.getKey().getFacilityID().equalsIgnoreCase(id))
                {
                    return villaIntegerEntry.getKey();
                }
            }
        }

        if(maID.equalsIgnoreCase("SVHO"))
        {
            for (Map.Entry<House,Integer> houseIntegerEntry:mapHouse.entrySet())
            {
                if(houseIntegerEntry.getKey().getFacilityID().equalsIgnoreCase(id))
                {
                    return houseIntegerEntry.getKey();
                }
            }
        }

        if(maID.equalsIgnoreCase("SVRO"))
        {
            for (Map.Entry<Room,Integer> roomIntegerEntry:mapRoom.entrySet())
            {
                if(roomIntegerEntry.getKey().getFacilityID().equalsIgnoreCase(id))
                {
                    return roomIntegerEntry.getKey();
                }
            }
        }

        return null;
    }

    public static boolean isEmpty()
    {
        if(mapVilla.size()!=0 || mapHouse.size()!=0 || mapRoom.size()!=0) return false;
        return true;
    }

    public static void increaseValue(Facility facility)
    {
        int value;
        if(facility instanceof Villa)
        {
            Villa villa=(Villa) facility;
            value=mapVilla.get(villa);
            if(value==4)
            {
                mapMainteID.add(villa.getFacilityID());
                mapVilla.put(villa,0);
            }
            else
                mapVilla.put(villa,++value);
            WriteReadFile.writeToFileFacility(WriteReadFile.FILE_VILLA,mapVilla);
        }
        else
        if(facility instanceof House)
        {
            House house=(House) facility;
            value=mapHouse.get(house);
            if(value==4)
            {
                mapMainteID.add(house.getFacilityID());
                mapHouse.put(house,0);
            }
            else
                mapHouse.put(house,++value);
            WriteReadFile.writeToFileFacility(WriteReadFile.FILE_HOUSE,mapHouse);
        }
        else
            if(facility instanceof Room)
            {
                Room room=(Room) facility;
                value=mapRoom.get(room);
                if(value==4)
                {
                    mapMainteID.add(room.getFacilityID());
                    mapRoom.put(room,0);
                }
                else
                    mapRoom.put(room,++value);
                WriteReadFile.writeToFileFacility(WriteReadFile.FILE_ROOM,mapRoom);
            }
            WriteReadFile.writeToFile(WriteReadFile.FILE_FACILITYMAINTEDID,mapMainteID);
    }

    public static int getValue(Facility facility)
    {
        if(facility instanceof Villa)
        {
            Villa villa=(Villa) facility;
            return mapVilla.get(villa);
        }
        else
        if(facility instanceof House)
        {
            House house=(House) facility;
            return mapHouse.get(house);
        }
        else
        if(facility instanceof Room)
        {
            Room room=(Room) facility;
            return mapRoom.get(room);
        }
        return -1;
    }

    public static void readFacilityVilla(String path)
    {
        WriteReadFile.readDataFromFileVilla(path,mapVilla);
    }

    public static void readFacilityHouse(String path)
    {
        WriteReadFile.readDataFromFileHouse(path,mapHouse);
    }

    public static void readFacilityRoom(String path)
    {
        WriteReadFile.readDataFromFileRoom(path,mapRoom);
    }

    public static void readFacilityMainteID(String path)
    {
        WriteReadFile.readDataFromFileID(path,mapMainteID);
    }
}

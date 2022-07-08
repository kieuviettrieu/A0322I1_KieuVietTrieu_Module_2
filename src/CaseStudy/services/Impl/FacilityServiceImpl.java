package CaseStudy.services.Impl;

import CaseStudy.models.*;
import CaseStudy.services.Interface.FacilityService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static String[] arayKieuThue={"","Year","Month","Day","Hour"};
    private static LinkedHashMap<Facility,Integer> mapFacility=new LinkedHashMap<>();
    @Override
    public void disPlayFMaintenance() {
        int dem=0;
        System.out.println("List of rooms in need of maintenance: ");
        if(mapFacility.size()!=0) {
            ArrayList<Facility> arrayMainten= new ArrayList<>(mapFacility.keySet());
            for (Facility facility : arrayMainten) {
                if(mapFacility.get(facility)!=5)
                    continue;
                if (facility instanceof House) {
                    House house = (House) facility;
                    System.out.println(house.toString()+", Number of uses: 5");
                }
                else if (facility instanceof Villa) {
                    Villa villa=(Villa) facility;
                    System.out.println(villa.toString()+", Number of uses: 5");
                }
                else
                {
                    Room room=(Room) facility;
                    System.out.println(room.toString()+", Number of uses: 5");
                }
                dem=1;
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
            mapFacility.put(facility,0);
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
        if(mapFacility.size()!=0) {
            ArrayList<Facility> arrayFacility= new ArrayList<>(mapFacility.keySet());

            for (Facility facility : arrayFacility) {
                if (facility instanceof House) {
                    House house = (House) facility;
                    System.out.println(house.toString()+", Number of uses: "+mapFacility.get(facility));
                }
                else if (facility instanceof Villa) {
                    Villa villa=(Villa) facility;
                    System.out.println(villa.toString()+", Number of uses: "+mapFacility.get(facility));
                }
                else
                    {
                        Room room=(Room) facility;
                        System.out.println(room.toString()+", Number of uses: "+mapFacility.get(facility));
                    }
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
        if(mapFacility.size()!=0) {
            ArrayList<Facility> arrayFacility= new ArrayList<>(mapFacility.keySet());

            for (Facility facility : arrayFacility) {
                if(!facility.getTenDichVu().equalsIgnoreCase(tenDichvu))
                    continue;

                if (facility instanceof House) {
                    House house = (House) facility;
                    System.out.println(house.toString()+", Number of uses: "+mapFacility.get(facility));
                }
                else if (facility instanceof Villa) {
                    Villa villa=(Villa) facility;
                    System.out.println(villa.toString()+", Number of uses: "+mapFacility.get(facility));
                }
                else
                {
                    Room room=(Room) facility;
                    System.out.println(room.toString()+", Number of uses: "+mapFacility.get(facility));
                }
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public boolean isFacility(String tenDichVu)
    {
        ArrayList<Facility> arrayFacility= new ArrayList<>(mapFacility.keySet());

        for (Facility facility:arrayFacility)
        {
            if(tenDichVu.equalsIgnoreCase(facility.getTenDichVu()))
            {
                return true;
            }
        }
        return false;
    }

    public Facility returnFacility()
    {
        Facility facility;
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.Villa");
        System.out.println("2.Room");
        System.out.println("3.House");
        System.out.println("0.Back to menu");
        System.out.print("Choose a room type: ");
        String name="";
        int choose=Integer.parseInt(scanner.nextLine());
        while (!(choose>=0 && choose<=3))
        {
            choose=Integer.parseInt(scanner.nextLine());
        }
        if(choose==0)
        {
            return null;
        }
        System.out.print("Area of the room to rent: ");
        double area=Double.parseDouble(scanner.nextLine());
        System.out.print("Rental costs: ");
        int cost=Integer.parseInt(scanner.nextLine());
        System.out.print("Maximum number of people: ");
        int maxPerson=Integer.parseInt(scanner.nextLine());
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
                System.out.print("Number of floors: ");
                int soTangVilla=Integer.parseInt(scanner.nextLine());
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
                facility=new House(name,area,cost,maxPerson,kieuThue,tieuChuanHouse,soTangHouse);
                break;
            default:
                facility=null;
        }
        return facility;
    }

    public static Facility searchFacility(int id)
    {
        if(mapFacility.size()!=0) {
            ArrayList<Facility> arrayFacility= new ArrayList<>(mapFacility.keySet());

            for (Facility facility : arrayFacility) {
                if(facility.getId()==id)
                {
                    return facility;
                }
            }
        }
        return null;
    }

    public static boolean isEmpty()
    {
        return mapFacility.isEmpty();
    }

    public static void increaseValue(Facility facility)
    {
        int value=mapFacility.get(facility);
        mapFacility.put(facility,++value);
    }

    public static int getValue(Facility facility)
    {
        if(facility==null)
            return -1;
        return mapFacility.get(facility);
    }
}

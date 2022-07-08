package CaseStudy.services.Impl;

import CaseStudy.models.Booking;
import CaseStudy.models.Contract;
import CaseStudy.models.Facility;
import CaseStudy.services.Interface.BookingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
    private static final String[] arrayNameService={null,"Villa","Room","House"};
    private static Scanner scanner=new Scanner(System.in);
    private static TreeSet<Booking> arrayBooking=new TreeSet<>();
    private static TreeSet<Contract> arrayContract=new TreeSet<>();

    @Override
    public void addNew(Booking booking) {
        if(booking!=null)
        {
            arrayBooking.add(booking);
            FacilityServiceImpl.increaseValue(FacilityServiceImpl.searchFacility(booking.getLoaiDichVu()));
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
    }

    @Override
    public void createNewConstracts(Contract contract) {
        if(contract!=null)
        {
            arrayContract.add(contract);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
    }

    @Override
    public void disPlayContracts() {
        System.out.println("List of contract: ");
        if(arrayBooking.size()==0)
        {
            System.out.println("Empty list!");
        }
        else
        {
            for (Contract contract:arrayContract)
            {
                System.out.println(contract.toString());
            }
        }
    }

    @Override
    public void editConstract() {
        if(arrayContract.size()==0)
        {
            System.out.println("No contract yet!");
            return;
        }
        else
        {
            Contract contract;
            int soHopDong;
            disPlayContracts();
            System.out.println("Edit contracts");
            while (true)
            {
                System.out.print("Enter the contract code: ");
                soHopDong=Integer.parseInt(scanner.nextLine());
                contract=searchContract(soHopDong);
                if(contract!=null)
                {
                    break;
                }
                else
                {
                    System.out.println("Please enter the correct contract code!");
                }
            }
            disPlay();
            int idBooking;
            String idBookingStr;
            Booking booking;
            while (true)
            {
                System.out.print("Booking code: ");
                idBookingStr=scanner.nextLine();
                idBooking=Integer.parseInt(idBookingStr);
                booking=searchBooking(idBooking);
                if(booking!=null)
                {
                    break;
                }
                else
                {
                    System.out.println("This booking code could not be found!");
                }
            }

            double tongThanhToan=totalPayment(booking);
            double tienCoc=tongThanhToan*0.2;
            Contract contractNew=new Contract(soHopDong,idBooking,tienCoc,tongThanhToan,booking.getMaKhachHang());
            arrayContract.remove(contract);
            arrayContract.add(contractNew);
            System.out.println("Update successful!");
        }
    }

    private Contract searchContract(int soHopDong)
    {
        for (Contract contract:arrayContract)
        {
            if(contract.getSoHopDong()==soHopDong)
            {
                return contract;
            }
        }
        return null;
    }

    @Override
    public void disPlay() {
        System.out.println("List of booking: ");
        if(arrayBooking.size()==0)
        {
            System.out.println("Empty list!");
        }
        else
        {
            for (Booking booking:arrayBooking)
            {
                System.out.println(booking.toString());
            }
        }
    }



    public Booking returnBooking()
    {
        FacilityServiceImpl facilityService=new FacilityServiceImpl();
        CustomerServiceImpl customerService=new CustomerServiceImpl();
        if(FacilityServiceImpl.isEmpty() || CustomerServiceImpl.isEmpty())
        {
            System.out.println("Insufficient information!");
            return null;
        }
        System.out.println("Enter information: ");
        System.out.print("ID: ");
        String idStr=scanner.nextLine();
        int id=Integer.parseInt(idStr);

        Date firstDay=null;
        boolean checkFirst=false;
        while (checkFirst==false)
        {
            System.out.print("Start day: ");
            String firstDayStr=scanner.nextLine();
            try {
                firstDay = simpleDateFormat.parse(firstDayStr);
                checkFirst=true;
            } catch (ParseException e) {
                System.out.println("Format: dd-MM-yyyy");
                checkFirst=false;
            }
        }

        Date endDay=null;
        boolean checkLast=false;
        while (checkLast==false)
        {
            System.out.print("End day: ");
            String endDayStr=scanner.nextLine();
            try {
                endDay = simpleDateFormat.parse(endDayStr);
                checkLast=true;
            } catch (ParseException e) {
                System.out.println("Format: dd-MM-yyyy");
                checkLast=false;
            }
        }


        customerService.disPlay();
        System.out.print("Customer code: ");
        String idCustomerStr=scanner.nextLine();
        int idCustomer=Integer.parseInt(idCustomerStr);
        System.out.print("Service name: 1.Villa  2.Room  3.House");
        int indexNameService;
        do {
            System.out.print("Choose your name service: ");
            indexNameService=Integer.parseInt(scanner.nextLine());


            if(indexNameService<=3 && indexNameService>=1)
            {
                if(!facilityService.isFacility(arrayNameService[indexNameService]))
                {
                    System.out.println("This service is currently unavailable!");
                    continue;
                }
                break;
            }
            else
            {
                System.out.println("Please re-enter room!");
            }
        }while (true);
        String nameService=arrayNameService[indexNameService];
        facilityService.disPlay(nameService);
        String idServiceStr;
        int idService;
        while (true)
        {
            System.out.print("Service code: ");
            idServiceStr=scanner.nextLine();
            idService=Integer.parseInt(idServiceStr);
            Facility facility1=FacilityServiceImpl.searchFacility(idService);
            if(facility1==null)
            {
                System.out.println("This service is not available!");
                continue;
            }
            if(FacilityServiceImpl.getValue(facility1)==5)
            {
                System.out.println("This room type is under maintenance!");
                continue;
            }
            break;
        }
        return new Booking(id,firstDay,endDay,idCustomer,nameService,idService);
    }

    public Contract returnContract()
    {
        if(arrayBooking.size()==0 || CustomerServiceImpl.isEmpty())
        {
            System.out.println("Insufficient information!");
            return null;
        }

        System.out.println("Enter information: ");
        System.out.print("Contract code: ");
        String idContractStr=scanner.nextLine();
        int idContract=Integer.parseInt(idContractStr);

        disPlay();
        int idBooking;
        String idBookingStr;
        Booking booking;
        while (true)
        {
            System.out.print("Booking code: ");
            idBookingStr=scanner.nextLine();
            idBooking=Integer.parseInt(idBookingStr);
            booking=searchBooking(idBooking);
            if(booking!=null)
            {
                break;
            }
            else
            {
                System.out.println("This booking code could not be found!");
            }
        }

        double tongThanhToan=totalPayment(booking);
        double tienCoc=tongThanhToan*0.2;

        Contract contract=new Contract(idContract,idBooking,tienCoc,tongThanhToan,booking.getMaKhachHang());
        return contract;
    }

    private static double totalPayment(Booking booking)
    {
        int thoiGian=1;
        int idFacility=booking.getLoaiDichVu();
        Facility facility=FacilityServiceImpl.searchFacility(idFacility);
        double totalPay=facility.getChiPhiThue()*thoiGian;
        return totalPay;
    }

    private static Booking searchBooking(int idBooking)
    {
        for (Booking booking:BookingServiceImpl.arrayBooking)
        {
            if(idBooking==booking.getMaBooking())
            {
                return booking;
            }
        }
        return null;
    }

}

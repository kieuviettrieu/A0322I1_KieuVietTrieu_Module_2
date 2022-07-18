package CaseStudy.services.Impl;

import CaseStudy.models.Booking;
import CaseStudy.models.Contract;
import CaseStudy.models.facitily.Facility;
import CaseStudy.services.Interface.BookingService;
import CaseStudy.utils.DateException;
import CaseStudy.utils.MatchesCheck;
import CaseStudy.utils.WriteReadFile;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    private static final String[] arrayNameService={null,"Villa","Room","House"};
    private static Scanner scanner=new Scanner(System.in);
    private static TreeSet<Booking> arrayBooking=new TreeSet<>();
    private static TreeSet<Contract> arrayContract=new TreeSet<>();
    private static CustomerServiceImpl customerService=new CustomerServiceImpl();

    @Override
    public void addNew(Booking booking) {
        if(booking!=null)
        {
            arrayBooking.add(booking);
            FacilityServiceImpl.increaseValue(FacilityServiceImpl.searchFacility(booking.getLoaiDichVu()));
            WriteReadFile.writeToBooking("D:\\Codegym\\module2\\src\\CaseStudy\\data\\booking.cvs",arrayBooking);
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
            System.out.println("Contract created: "+contract);
            arrayContract.add(contract);
            WriteReadFile.writeToContract("D:\\Codegym\\module2\\src\\CaseStudy\\data\\contract.cvs",arrayContract);
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
        try {
            if (arrayContract.size() == 0) {
                System.out.println("No contract yet!");
                return;
            } else
                if(arrayContract.size()==arrayBooking.size())
                {
                    System.out.println("There are no new profiles to edit!");
                }
                else
                {
                Contract contract;
                int soHopDong;
                disPlayContracts();
                System.out.println("Edit contracts");
                while (true) {
                    System.out.print("Enter the contract code: ");
                    soHopDong = Integer.parseInt(scanner.nextLine());
                    contract = searchContract(soHopDong);
                    if (contract != null) {
                        break;
                    } else {
                        System.out.println("Please enter the correct contract code!");
                    }
                }
                disPlay();
                int idBooking;
                String idBookingStr;
                Booking booking;
                while (true) {
                    System.out.print("Booking code: ");
                    idBookingStr = scanner.nextLine();
                    idBooking = Integer.parseInt(idBookingStr);
                    booking = searchBooking(idBooking);
                    if (booking != null) {
                        if(checkIDContract(idBooking))
                            break;
                        else
                            System.out.println("This profile has been created!");
                    } else {
                        System.out.println("This booking code could not be found!");
                    }
                }

                double tongThanhToan = totalPayment(booking);
                double tienCoc = tongThanhToan * 0.2;
                Contract contractNew = new Contract(soHopDong, idBooking, tienCoc, tongThanhToan, booking.getMaKhachHang());
                arrayContract.remove(contract);
                arrayContract.add(contractNew);
                WriteReadFile.writeToContract("D:\\Codegym\\module2\\src\\CaseStudy\\data\\contract.cvs", arrayContract);
                System.out.println("Update successful!");
            }
        }catch (Exception e)
        {
            System.out.println("Input data is wrong!");
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
        int id;
        while (true)
        {
            System.out.print("ID: ");
            String idStr=scanner.nextLine();
            if(MatchesCheck.checkId(idStr))
            {
                id=Integer.parseInt(idStr);
                break;
            }
            System.out.println("Format ID: 1xxx");
        }

        Date firstDay=null;
        while (true)
        {
            System.out.print("Start day: ");
            String firstDayStr=scanner.nextLine();
            if(MatchesCheck.checkDate(firstDayStr))
            {
                try {
                    firstDay = DateException.simpleDateFormat.parse(firstDayStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
            System.out.println("Format: dd-MM-yyyy");
        }

        Date endDay=null;
        while (true)
        {
            System.out.print("End day: ");
            String lastDayStr=scanner.nextLine();
            if(MatchesCheck.checkDate(lastDayStr) )
            {
                try {
                    endDay = DateException.simpleDateFormat.parse(lastDayStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(firstDay.compareTo(endDay)<0)
                    break;
            }
            System.out.println("Format: dd-MM-yyyy");
        }

        customerService.disPlay();
        String idCustomerStr;
        int idCustomer;
        while (true)
        {
            System.out.print("Customer code: ");
            idCustomerStr=scanner.nextLine();
            if(MatchesCheck.checkId(idCustomerStr))
            {
                idCustomer=Integer.parseInt(idCustomerStr);
                if(customerService.getCustomer(idCustomer)!=null)
                    break;
            }
            System.out.println("This code could not be found!");
        }

        System.out.println("Service name: 1.Villa  2.Room  3.House");
        int indexNameService;
        do {
            System.out.print("Choose your name service: ");
            String indexStr=scanner.nextLine();
            if(MatchesCheck.checkOneNumber(indexStr))
            {
                indexNameService=Integer.parseInt(indexStr);
                if(indexNameService<=3 && indexNameService>=1)
                {
                    if(!facilityService.isFacility(arrayNameService[indexNameService]))
                    {
                        System.out.println("This service is currently unavailable!");
                        continue;
                    }
                    break;
                }
            }
            else
            {
                System.out.println("Please re-enter room!");
            }
        }while (true);
        String nameService=arrayNameService[indexNameService];
        facilityService.disPlay(nameService);
        String idServiceStr;
        while (true)
        {
            System.out.print("Service code: ");
            idServiceStr=scanner.nextLine();
            Facility facility1=FacilityServiceImpl.searchFacility(idServiceStr);
            if(facility1==null)
            {
                System.out.println("This service is not available!");
                continue;
            }
            break;
        }
        return new Booking(id,firstDay,endDay,idCustomer,nameService,idServiceStr);
    }

    public Contract returnContract()
    {
        if(arrayBooking.size()==0 || CustomerServiceImpl.isEmpty())
        {
            System.out.println("Insufficient information!");
            return null;
        }

        System.out.println("Enter information: ");
        int idContract;
        while (true)
        {
            System.out.print("Contract code: ");
            String idContractStr=scanner.nextLine();
            if(MatchesCheck.checkId(idContractStr))
            {
                idContract=Integer.parseInt(idContractStr);
                if(checkID(idContract))
                    break;
                else
                    System.out.println("This code already exists!");
            }
            System.out.println("Format ID: 1xxx");
        }

        Booking booking=null;
        for (Booking booking1:arrayBooking)
        {
            if(checkIDContract(booking1.getMaBooking()))
            {
                booking=booking1;
                break;
            }
        }
        if(booking==null)
        {
            System.out.println("No new profiles to create yet");
            return null;
        }

        double tongThanhToan=(long)totalPayment(booking);
        double tienCoc=(long)tongThanhToan*0.2;
        Contract contract=new Contract(idContract,booking.getMaBooking(),tienCoc,tongThanhToan,booking.getMaKhachHang());
        return contract;
    }

    private static double totalPayment(Booking booking)
    {
        int maKhachHang=booking.getMaKhachHang();
        double voucher=VoucherServices.getVoucher(maKhachHang)/100;
        String idFacility=booking.getLoaiDichVu();
        Facility facility=FacilityServiceImpl.searchFacility(idFacility);
        double phiThueDay=getPhiThueNgay(facility);
        int numberDay=daysBetween(booking.getFirstDate(),booking.getLastDate());
        double totalPay=numberDay*phiThueDay*(1-voucher);
        return totalPay;
    }

    public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    private static double getPhiThueNgay(Facility facility)
    {
        double phiThueDay;
        String[] arayKieuThue={"","Year","Month","Day","Hour"};
        String kieuThue=facility.getKieuThue();
        double phiThue=facility.getChiPhiThue();
        if(kieuThue.equalsIgnoreCase(arayKieuThue[1]))
            phiThueDay=phiThue/365;
        else
            if(kieuThue.equalsIgnoreCase(arayKieuThue[2]))
                phiThueDay=phiThue/30;
            else
                if(kieuThue.equalsIgnoreCase(arayKieuThue[4]))
                    phiThueDay=phiThue*24;
                else
                    phiThueDay=phiThue;
        return phiThueDay;
    }

    public static Booking searchBooking(int idBooking)
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

    private static boolean checkID(int idContract)
    {
        for (Contract contract: arrayContract)
        {
            if(contract.getSoHopDong()==idContract)
                return false;
        }
        return true;
    }

    private static boolean checkIDContract(int idBook)
    {
        for (Contract contract: arrayContract)
        {
            if(contract.getMaBooking()==idBook)
                return false;
        }
        return true;
    }

    public TreeSet<Booking> getTreeSetBooking()
    {
        return arrayBooking;
    }

    public static void readTreeSetBook(String path)
    {
        WriteReadFile.readDataFromFileBook(path,arrayBooking);
    }

    public static void readTreeSetContract(String path)
    {
        WriteReadFile.readDataFromFileContract(path,arrayContract);
    }
}

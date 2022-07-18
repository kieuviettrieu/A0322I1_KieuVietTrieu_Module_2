package CaseStudy.controllers;

import CaseStudy.models.*;
import CaseStudy.models.facitily.Facility;
import CaseStudy.models.person.Customer;
import CaseStudy.models.person.Employee;
import CaseStudy.services.Impl.*;
import java.util.Scanner;

public class FuramaController {
    private static final String EMPLOYEEMANAGEMENT="1";
    private static final String CUSTOMERMANAGEMENT="2";
    private static final String FACILITYMANAGEMENT="3";
    private static final String BOOKINGMANAGEMENT="4";
    private static final String PROMOTIONMANAGEMENT="5";
    private static final String EXIT="0";
    private static Scanner scanner;

    public static void main(String[] args) {
        readData();
        displayMainMenu();
    }

    private static void readData()
    {
        EmployeeServiceImpl.readArrayEmployee("D:\\Codegym\\module2\\src\\CaseStudy\\data\\employee.cvs");
        CustomerServiceImpl.readArrayCostomer("D:\\Codegym\\module2\\src\\CaseStudy\\data\\customer.cvs");
        FacilityServiceImpl.readFacilityVilla("D:\\Codegym\\module2\\src\\CaseStudy\\data\\villa.cvs");
        FacilityServiceImpl.readFacilityHouse("D:\\Codegym\\module2\\src\\CaseStudy\\data\\house.cvs");
        FacilityServiceImpl.readFacilityRoom("D:\\Codegym\\module2\\src\\CaseStudy\\data\\room.cvs");
        FacilityServiceImpl.readFacilityMainteID("D:\\Codegym\\module2\\src\\CaseStudy\\data\\facilityid.cvs");
        BookingServiceImpl.readTreeSetBook("D:\\Codegym\\module2\\src\\CaseStudy\\data\\booking.cvs");
        BookingServiceImpl.readTreeSetContract("D:\\Codegym\\module2\\src\\CaseStudy\\data\\contract.cvs");
        VoucherServices.readToVoucher("D:\\Codegym\\module2\\src\\CaseStudy\\data\\voucher.cvs");
    }

    private static void displayMainMenu()
    {
        scanner=new Scanner(System.in);
        String goTo;
        do {
            menu();
            System.out.println();
            System.out.print("Select function: ");
            goTo=scanner.nextLine();
            switch (goTo)
            {
                case EMPLOYEEMANAGEMENT:
                    employeeManagement();
                    break;
                case CUSTOMERMANAGEMENT:
                    customerManagement();
                    break;
                case FACILITYMANAGEMENT:
                    facilityManagement();
                    break;
                case BOOKINGMANAGEMENT:
                    bookingManagement();
                    break;
                case PROMOTIONMANAGEMENT:
                    promotionManagement();
                    break;
                case EXIT:
                    System.exit(0);
                default:
                    System.out.println("Please select the function available in the menu!");
            }

        }while (goTo!=EXIT);
    }

    private static void menu()
    {
        System.out.println("----------MENU----------");
        System.out.println("1.Employee Management");
        System.out.println("2.Customer Management");
        System.out.println("3.Facility Management");
        System.out.println("4.Booking Management");
        System.out.println("5.Promotion Management");
        System.out.println("0.Exit");
    }

    private static void employeeManagement()
    {
        EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
        String count;
        do {
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employee");
            System.out.println("3.Edit employee");
            System.out.println("4.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextLine();
            switch (count)
            {
                case "1":
                    employeeServiceImpl.disPlay();
                    break;
                case "2":
                    try {
                        Employee employee=employeeServiceImpl.returnEmployee();
                        employeeServiceImpl.addNew(employee);
                    }catch (Exception e)
                    {
                        System.out.println("Input data is wrong!");
                    }
                    break;
                case "3":
                    employeeServiceImpl.editEmployee();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please select the function available in the menu!");
            }
            System.out.println();
        }while (true);
    }

    private static void customerManagement()
    {
        CustomerServiceImpl customerServiceImpl=new CustomerServiceImpl();
        String count;
        do {
            System.out.println("1.Display list customers");
            System.out.println("2.Add new customer");
            System.out.println("3.Edit customer");
            System.out.println("4.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextLine();
            switch (count)
            {
                case "1":
                    customerServiceImpl.disPlay();
                    break;
                case "2":
                    try {
                        Customer customer=customerServiceImpl.returnCustomer();
                        customerServiceImpl.addNew(customer);
                    }catch (Exception e)
                    {
                        System.out.println("Input data is wrong!");
                    }
                    break;
                case "3":
                    customerServiceImpl.editCustomer();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please select the function available in the menu!");
            }
            System.out.println();
        }while (true);
    }

    private static void facilityManagement()
    {
        FacilityServiceImpl facilityServiceImpl=new FacilityServiceImpl();
        String count;
        do {
            System.out.println("1.Display list facility");
            System.out.println("2.Add new facility");
            System.out.println("3.Display list facility maintenance");
            System.out.println("4.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextLine();
            switch (count)
            {
                case "1":
                    facilityServiceImpl.disPlay();
                    break;
                case "2":
                    try {
                        Facility facility=facilityServiceImpl.returnFacility();
                        facilityServiceImpl.addNew(facility);
                    }catch (Exception e)
                    {
                        System.out.println("Input data is wrong!");
                    }
                    break;
                case "3":
                    facilityServiceImpl.disPlayFMaintenance();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please select the function available in the menu!");
            }
            System.out.println();
        }while (true);
    }


    private static void bookingManagement()
    {
        BookingServiceImpl bookingServiceIpml=new BookingServiceImpl();
        String count;
        do {
            System.out.println("1.Add new booking");
            System.out.println("2.Display list booking");
            System.out.println("3.Create new constracts");
            System.out.println("4.Display list contracts");
            System.out.println("5.Edit contracts");
            System.out.println("6.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextLine();
            switch (count)
            {
                case "1":
                    try {
                        Booking booking=bookingServiceIpml.returnBooking();
                        bookingServiceIpml.addNew(booking);
                    }catch (Exception e)
                    {
                        System.out.println("Input data is wrong!");
                    }
                    break;
                case "2":
                    bookingServiceIpml.disPlay();
                    break;
                case "3":
                    try {
                        Contract contract=bookingServiceIpml.returnContract();
                        bookingServiceIpml.createNewConstracts(contract);
                    }catch (Exception e)
                    {
                        System.out.println("Input data is wrong!");
                    }
                    break;
                case "4":
                    bookingServiceIpml.disPlayContracts();
                    break;
                case "5":
                    bookingServiceIpml.editConstract();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Please select the function available in the menu!");
            }
            System.out.println();
        }while (true);
    }

    private static void promotionManagement()
    {
        String count;
        PromotionServiceImpl promotionServiceImpl=new PromotionServiceImpl();
        do {
            System.out.println("1.Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextLine();
            switch (count)
            {
                case "1":
                    promotionServiceImpl.disPlayUseService();
                    break;
                case "2":
                    promotionServiceImpl.disPlayGetVoucher();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Please select the function available in the menu!");
            }
            System.out.println();
        }while (true);
    }

    public static void delay(long sleep)
    {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}





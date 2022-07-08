package CaseStudy.controllers;

import CaseStudy.models.*;
import CaseStudy.services.Impl.*;

import java.util.Date;
import java.util.Scanner;

public class FuramaController {
    private static final int EMPLOYEEMANAGEMENT=1;
    private static final int CUSTOMERMANAGEMENT=2;
    private static final int FACILITYMANAGEMENT=3;
    private static final int BOOKINGMANAGEMENT=4;
    private static final int PROMOTIONMANAGEMENT=5;
    private static final int EXIT=0;
    private static Scanner scanner;

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu()
    {
        scanner=new Scanner(System.in);
        int goTo;
        do {
            menu();
            System.out.println();
            System.out.print("Select function: ");
            goTo=scanner.nextInt();
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
        int count;
        do {
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employee");
            System.out.println("3.Edit employee");
            System.out.println("4.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:
                    employeeServiceImpl.disPlay();
                    break;
                case 2:
                    Employee employee=employeeServiceImpl.returnEmployee();
                    employeeServiceImpl.addNew(employee);
                    break;
                case 3:
                    employeeServiceImpl.editEmployee();
                    break;
                case 4:
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
        int count;
        do {
            System.out.println("1.Display list customers");
            System.out.println("2.Add new customer");
            System.out.println("3.Edit customer");
            System.out.println("4.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:
                    customerServiceImpl.disPlay();
                    break;
                case 2:
                    Customer customer=customerServiceImpl.returnCustomer();
                    customerServiceImpl.addNew(customer);
                    break;
                case 3:
                    customerServiceImpl.editCustomer();
                    break;
                case 4:
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
        int count;
        do {
            System.out.println("1.Display list facility");
            System.out.println("2.Add new facility");
            System.out.println("3.Display list facility maintenance");
            System.out.println("4.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:
                    facilityServiceImpl.disPlay();
                    break;
                case 2:
                    System.out.println("Enter information: ");
                    Facility facility=facilityServiceImpl.returnFacility();
                    facilityServiceImpl.addNew(facility);
                    break;
                case 3:
                    facilityServiceImpl.disPlayFMaintenance();
                    break;
                case 4:
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
        int count;
        do {
            System.out.println("1.Add new booking");
            System.out.println("2.Display list booking");
            System.out.println("3.Create new constracts");
            System.out.println("4.Display list contracts");
            System.out.println("5.Edit contracts");
            System.out.println("6.Return main menu");
            System.out.print("Select function: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:
                    Booking booking=bookingServiceIpml.returnBooking();
                    bookingServiceIpml.addNew(booking);
                    break;
                case 2:
                    bookingServiceIpml.disPlay();
                    break;
                case 3:
                    Contract contract=bookingServiceIpml.returnContract();
                    bookingServiceIpml.createNewConstracts(contract);
                    break;
                case 4:
                    bookingServiceIpml.disPlayContracts();
                    break;
                case 5:
                    bookingServiceIpml.editConstract();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Please select the function available in the menu!");
            }
            System.out.println();
        }while (true);
    }

    private static void promotionManagement()
    {
        System.out.println("1.Display list customers use service");
        System.out.println("2.Display list customers get voucher");
        System.out.println("3.Return main menu");
        int count;
        PromotionServiceImpl promotionServiceImpl=new PromotionServiceImpl();
        do {
            System.out.print("Select function: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
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





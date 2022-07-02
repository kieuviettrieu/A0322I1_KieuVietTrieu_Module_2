package CaseStudy.controllers;

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
            System.out.print("Chọn chức năng: ");
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
                    System.out.println("Vui lòng chọn chức năng có trong menu!");
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
        System.out.println("1.Display list employees");
        System.out.println("2.Add new employee");
        System.out.println("3.Edit employee");
        System.out.println("4.Return main menu");
        int count;
        do {
            System.out.print("Chọn chức năng: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng có trong menu!");
            }
        }while (count>4 || count<=0);
    }

    private static void customerManagement()
    {
        System.out.println("1.Display list customers");
        System.out.println("2.Add new customer");
        System.out.println("3.Edit customer");
        System.out.println("4.Return main menu");
        int count;
        do {
            System.out.print("Chọn chức năng: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng có trong menu!");
            }
        }while (count>4 || count<=0);
    }

    private static void facilityManagement()
    {
        System.out.println("1.Display list facility");
        System.out.println("2.Add new facility");
        System.out.println("3.Display list facility maintenance");
        System.out.println("4.Return main menu");
        int count;
        do {
            System.out.print("Chọn chức năng: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng có trong menu!");
            }
        }while (count>4 || count<=0);
    }


    private static void bookingManagement()
    {
        System.out.println("1.Add new booking");
        System.out.println("2.Display list booking");
        System.out.println("3.Create new constracts");
        System.out.println("4.Display list contracts");
        System.out.println("5.Edit contracts");
        System.out.println("6.Return main menu");
        int count;
        do {
            System.out.print("Chọn chức năng: ");
            count=scanner.nextInt();
            switch (count)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng có trong menu!");
            }
        }while (count>6 || count<=0);
    }

    private static void promotionManagement()
    {
        System.out.println("1.Display list customers use service");
        System.out.println("2.Display list customers get voucher");
        System.out.println("3.Return main menu");
        int count;
        do {
            System.out.print("Chọn chức năng: ");
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
                    System.out.println("Vui lòng chọn chức năng có trong menu!");
            }
        }while (count>3 || count<=0);
    }

}





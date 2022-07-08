package CaseStudy.services.Impl;

import CaseStudy.models.Customer;
import CaseStudy.services.Interface.CustomerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner=new Scanner(System.in);
    private static LinkedList<Customer> arrayCustomer=new LinkedList<>();
    private static final String[] arrayType={null,"Diamond","Platinium","Gold","Silver","Member"};


    @Override
    public void editCustomer() {
        if(arrayCustomer.size()==0)
        {
            System.out.println("Employee list is empty!");
            return;
        }
        System.out.println("Enter employee code: ");
        System.out.print("ID: ");
        int id=Integer.parseInt(scanner.nextLine());
        int index=indexCustomer(id);
        if(index!=-1)
        {
            System.out.println(arrayCustomer.get(index).toString());
            System.out.println("Edit information:");
            System.out.print("Full name: ");
            String fullname=scanner.nextLine();
            System.out.print("Birth day: ");
            String birthday=scanner.nextLine();
            System.out.print("Set: ");
            String set=scanner.nextLine();
            System.out.println("Type: 1.Diamond  2.Platinium  3.Gold  4.Silver  5.Member");
            int indexType;
            do {
                System.out.print("Choose your type: ");
                indexType=Integer.parseInt(scanner.nextLine());
                if(indexType<=5 && indexType>=1)
                {
                    break;
                }
                else
                {
                    System.out.println("Please re-enter room!");
                }
            }while (true);
            String loaiKhach=arrayType[indexType];
            System.out.println("Address: ");
            String address=scanner.nextLine();
            System.out.print("Phone number: ");
            String phonenumber=scanner.nextLine();
            System.out.print("Email: ");
            String email=scanner.nextLine();
            System.out.print("CCCD: ");
            String cccd=scanner.nextLine();
            arrayCustomer.set(index,new Customer(id,fullname,new Date(birthday),set,phonenumber,email,cccd,loaiKhach,address));
            System.out.println("Update successful!");
        }
        else {
            System.out.println("This customer code does not exist!");
        }
    }

    private int indexCustomer(int id)
    {
        int index=-1;
        for (int i=0; i<arrayCustomer.size(); i++)
        {
            if (id==arrayCustomer.get(i).getMaKhachHang())
            {
                index=i;
                break;
            }
        }
        return index;
    }

    @Override
    public void addNew(Customer customer) {
        if(customer!=null)
        {
            arrayCustomer.add(customer);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
    }

    @Override
    public void disPlay() {
        System.out.println("List of customer: ");
        if(arrayCustomer.size()!=0)
        {
            for (Customer customer:arrayCustomer)
            {
                System.out.println(customer.toString());
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public Customer returnCustomer()
    {
        System.out.println("Enter information: ");
        System.out.print("ID: ");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.print("Full name: ");
        String fullname=scanner.nextLine();
        System.out.print("Birth day: ");
        String birthday=scanner.nextLine();
        System.out.print("Set: ");
        String set=scanner.nextLine();
        System.out.println("Type: 1.Diamond  2.Platinium  3.Gold  4.Silver  5.Member");
        int indexType;
        do {
            System.out.print("Choose your type: ");
            indexType=Integer.parseInt(scanner.nextLine());
            if(indexType<=5 && indexType>=1)
            {
                break;
            }
            else
            {
                System.out.println("Please re-enter room!");
            }
        }while (true);
        String loaiKhach=arrayType[indexType];
        System.out.println("Address: ");
        String address=scanner.nextLine();
        System.out.print("Phone number: ");
        String phonenumber=scanner.nextLine();
        System.out.print("Email: ");
        String email=scanner.nextLine();
        System.out.print("CCCD: ");
        String cccd=scanner.nextLine();
        return new Customer(id,fullname,new Date(birthday),set,phonenumber,email,cccd,loaiKhach,address);
    }

    public static boolean isEmpty()
    {
        return arrayCustomer.isEmpty();
    }
}

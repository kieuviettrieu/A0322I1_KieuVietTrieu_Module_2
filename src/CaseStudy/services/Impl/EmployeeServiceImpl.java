package CaseStudy.services.Impl;

import CaseStudy.models.Employee;
import CaseStudy.services.Interface.EmployeeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static ArrayList<Employee> arrayEmployee=new ArrayList<>();
    private static final String[] arrayLevel={null,"Intermediate","College","Undergraduate","Graduate"};
    private static final String[] arrayLocation={null,"Receptionist","Waiter","Specialist","Supervisor","Manager","Director"};

    @Override
    public void editEmployee() {
        Scanner scanner=new Scanner(System.in);
        if(arrayEmployee.size()==0)
        {
            System.out.println("Employee list is empty!");
            return;
        }
        System.out.println("Enter employee code: ");
        System.out.print("ID: ");
        int id=scanner.nextInt();
        int index=indexEmployee(id);
        if(index!=-1)
        {
            System.out.println(arrayEmployee.get(index).toString());
            System.out.println("Edit information:");
            scanner.nextLine();
            System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
            int indexLevel;
            do {
                System.out.print("Choose your level: ");
                indexLevel=Integer.parseInt(scanner.nextLine());
                if(indexLevel<=4 && indexLevel>=1)
                {
                    break;
                }
                else
                {
                    System.out.println("Please re-enter room!");
                }
            }while (true);
            String level=arrayLevel[indexLevel];
            int indexLocation;
            System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
            do {
                System.out.print("Choose your location: ");
                indexLocation=Integer.parseInt(scanner.nextLine());
                if(indexLocation<=6 && indexLocation>=1)
                {
                    break;
                }
                else
                {
                    System.out.println("Please re-enter room!");
                }
            }while (true);
            String location=arrayLocation[indexLocation];
            System.out.print("Wage: ");
            double wage=Double.parseDouble(scanner.nextLine());
            System.out.print("Full name: ");
            String fullname=scanner.nextLine();
            System.out.print("Birth day: ");
            String birthday=scanner.nextLine();
            System.out.print("Set: ");
            String set=scanner.nextLine();
            System.out.print("Phone number: ");
            String phonenumber=scanner.nextLine();
            System.out.print("Email: ");
            String email=scanner.nextLine();
            System.out.print("CCCD: ");
            String cccd=scanner.nextLine();
            arrayEmployee.set(index,new Employee(fullname,new Date(birthday),set,phonenumber,email,cccd,id,level,location,wage));
            System.out.println("Update successful!");
        }
        else
        {
            System.out.println("This employee code does not exist!");
        }
    }

    @Override
    public void addNew(Employee employee) {
        if(employee!=null)
        {
            arrayEmployee.add(employee);
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }

    }

    @Override
    public void disPlay() {
        System.out.println("List of employee: ");
        if(arrayEmployee.size()!=0)
        {
            for (Employee employee:arrayEmployee)
            {
                System.out.println(employee.toString());
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    private int indexEmployee(int id)
    {
        int index=-1;
        for (int i=0; i<arrayEmployee.size(); i++)
        {
            if (id==arrayEmployee.get(i).getMaNhanVien())
            {
                index=i;
                break;
            }
        }
        return index;
    }

    public Employee returnEmployee()
    {
        System.out.println("Enter information: ");
        Scanner scanner=new Scanner(System.in);
        System.out.print("ID: ");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
        int indexLevel;
        do {
            System.out.print("Choose your level: ");
            indexLevel=Integer.parseInt(scanner.nextLine());
            if(indexLevel<=4 && indexLevel>=1)
            {
                break;
            }
            else
            {
                System.out.println("Please re-enter room!");
            }
        }while (true);
        String level=arrayLevel[indexLevel];

        int indexLocation;
        System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
        do {
            System.out.print("Choose your location: ");
            indexLocation=Integer.parseInt(scanner.nextLine());
            if(indexLocation<=6 && indexLocation>=1)
            {
                break;
            }
            else
            {
                System.out.println("Please re-enter room!");
            }
        }while (true);
        String location=arrayLocation[indexLocation];
        System.out.print("Wage: ");
        double wage=Double.parseDouble(scanner.nextLine());
        System.out.print("Full name: ");
        String fullname=scanner.nextLine();
        System.out.print("Birth day: ");
        String birthday=scanner.nextLine();
        System.out.print("Set: ");
        String set=scanner.nextLine();
        System.out.print("Phone number: ");
        String phonenumber=scanner.nextLine();
        System.out.print("Email: ");
        String email=scanner.nextLine();
        System.out.print("CCCD: ");
        String cccd=scanner.nextLine();
        return new Employee(fullname,new Date(birthday),set,phonenumber,email,cccd,id,level,location,wage);
    }
}

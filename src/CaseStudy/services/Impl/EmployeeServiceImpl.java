package CaseStudy.services.Impl;

import CaseStudy.models.Employee;
import CaseStudy.services.Interface.EmployeeService;
import CaseStudy.services.exception.DateException;
import CaseStudy.services.exception.MatchesCheck;
import CaseStudy.services.exception.WriteReadFile;

import java.text.ParseException;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> arrayEmployee=new ArrayList<>();
    private static final String[] arrayLevel={null,"Intermediate","College","Undergraduate","Graduate"};
    private static final String[] arrayLocation={null,"Receptionist","Waiter","Specialist","Supervisor","Manager","Director"};
    private static final String[] arraySet={"Khác","Nam","Nữ"};

    @Override
    public void editEmployee() {
        try {
            Scanner scanner=new Scanner(System.in);
            if(arrayEmployee.size()==0)
            {
                System.out.println("Employee list is empty!");
                return;
            }
            disPlay();
            System.out.print("Edit Employee ID: ");
            int id=scanner.nextInt();
            int index=indexEmployee(id);
            if(index!=-1)
            {
                System.out.println(arrayEmployee.get(index).toString());
                System.out.println("Edit information:");
                scanner.nextLine();
                System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
                int indexLevel;
                while (true)
                {
                    System.out.print("Choose your level: ");
                    String indexLevelStr=scanner.nextLine();
                    if(MatchesCheck.checkOneNumber(indexLevelStr))
                    {
                        indexLevel=Integer.parseInt(indexLevelStr);
                        if(indexLevel<=4 && indexLevel>=1)
                        {
                            break;
                        }
                    }
                    System.out.println("Please re-enter room!");
                }

                String level=arrayLevel[indexLevel];

                int indexLocation;
                System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
                while (true){
                    System.out.print("Choose your location: ");
                    String indexStr=scanner.nextLine();
                    if(MatchesCheck.checkOneNumber(indexStr))
                    {
                        indexLocation=Integer.parseInt(indexStr);
                        if(indexLocation<=6 && indexLocation>=1)
                        {
                            break;
                        }
                    }
                    System.out.println("Please re-enter room!");
                }
                String location=arrayLocation[indexLocation];
                System.out.print("Wage: ");
                double wage=Double.parseDouble(scanner.nextLine());
                System.out.print("Full name: ");
                String fullname=scanner.nextLine();
                Date birthDay=null;
                while (true)
                {
                    System.out.print("Birthday: ");
                    String birthDayStr=scanner.nextLine();
                    if(MatchesCheck.checkDate(birthDayStr))
                    {
                        try {
                            birthDay=DateException.simpleDateFormat.parse(birthDayStr);
                            if(!(DateException.checkAge18(birthDay) && !DateException.checkAge100(birthDay)))
                            {
                                System.out.println("Age>=18 and Age<=100");
                                continue;
                            }
                        } catch (ParseException e) {
                            System.out.println("Errol BirthDay!");
                        }
                        break;
                    }
                    System.out.println("Format: dd-MM-yyyy");
                }
                String set;
                while (true)
                {
                    System.out.println("Set: 0.Khác  1.Nam  2.Nữ");
                    System.out.print("Choose: ");
                    String indexSet=scanner.nextLine();
                    if(MatchesCheck.checkOneNumber(indexSet))
                    {
                        int inde=Integer.parseInt(indexSet);
                        if(inde>=0 && inde<=2)
                        {
                            set=arraySet[inde];
                            break;
                        }
                        System.out.println("Please choose again!");
                    }
                }
                System.out.print("Phone number: ");
                String phonenumber=scanner.nextLine();
                String email;
                while (true)
                {
                    System.out.print("Email: ");
                    email=scanner.nextLine();
                    if(MatchesCheck.checkEmail(email))
                        break;
                    System.out.println("Email form: *.@gmail.com");
                }
                System.out.print("CCCD: ");
                String cccd=scanner.nextLine();
                arrayEmployee.set(index,new Employee(fullname,birthDay,set,phonenumber,email,cccd,id,level,location,wage));
                WriteReadFile.writeToFile("employee.cvs",arrayEmployee);
                System.out.println("Update successful!");
            }
            else
            {
                System.out.println("This employee code does not exist!");
            }
        }catch (Exception e)
        {
            System.out.println("Input data is wrong!");
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
        Collections.sort(arrayEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
        WriteReadFile.writeToFile("employee.cvs",arrayEmployee);
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
        System.out.println("Level: 1.Middle School  2.College  3.University  4.After university");
        int indexLevel;
        while (true)
        {
            System.out.print("Choose your level: ");
            String indexLevelStr=scanner.nextLine();
            if(MatchesCheck.checkOneNumber(indexLevelStr))
            {
                indexLevel=Integer.parseInt(indexLevelStr);
                if(indexLevel<=4 && indexLevel>=1)
                {
                    break;
                }
            }
            System.out.println("Please re-enter room!");
        }

        String level=arrayLevel[indexLevel];

        int indexLocation;
        System.out.println("Location: 1.Receptionist  2.Waiter  3.Specialist  4.Supervisor  5.Manager  6.Director");
        while (true){
            System.out.print("Choose your location: ");
            String indexStr=scanner.nextLine();
            if(MatchesCheck.checkOneNumber(indexStr))
            {
                indexLocation=Integer.parseInt(indexStr);
                if(indexLocation<=6 && indexLocation>=1)
                {
                    break;
                }
            }
            System.out.println("Please re-enter room!");
        }
        String location=arrayLocation[indexLocation];
        System.out.print("Wage: ");
        double wage=Double.parseDouble(scanner.nextLine());
        System.out.print("Full name: ");
        String fullname=scanner.nextLine();
        Date birthDay=null;
        while (true)
        {
            System.out.print("Birthday: ");
            String birthDayStr=scanner.nextLine();
            if(MatchesCheck.checkDate(birthDayStr))
            {
                try {
                    birthDay=DateException.simpleDateFormat.parse(birthDayStr);
                    if(!(DateException.checkAge18(birthDay) && !DateException.checkAge100(birthDay)))
                    {
                        System.out.println("Age>=18 and Age<=100");
                        continue;
                    }
                } catch (ParseException e) {
                    System.out.println("Errol BirthDay!");
                }
                break;
            }
            System.out.println("Format: dd-MM-yyyy");
        }
        String set;
        while (true)
        {
            System.out.println("Set: 0.Khác  1.Nam  2.Nữ");
            System.out.print("Choose: ");
            String indexSet=scanner.nextLine();
            if(MatchesCheck.checkOneNumber(indexSet))
            {
                int inde=Integer.parseInt(indexSet);
                if(inde>=0 && inde<=2)
                {
                    set=arraySet[inde];
                    break;
                }
                System.out.println("Please choose again!");
            }
        }
        System.out.print("Phone number: ");
        String phonenumber=scanner.nextLine();
        String email;
        while (true)
        {
            System.out.print("Email: ");
            email=scanner.nextLine();
            if(MatchesCheck.checkEmail(email))
                break;
            System.out.println("Email form: *.@gmail.com");
        }
        System.out.print("CCCD: ");
        String cccd=scanner.nextLine();
        return new Employee(fullname,birthDay,set,phonenumber,email,cccd,id,level,location,wage);
    }

    public static void setArrayEmployee(List<Employee> list)
    {
        arrayEmployee=list;
    }

    public static void readArrayEmployee(String path)
    {
        WriteReadFile.readDataFromFileEmp(path,arrayEmployee);
    }
}

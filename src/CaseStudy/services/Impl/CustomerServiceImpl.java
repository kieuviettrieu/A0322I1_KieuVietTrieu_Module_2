package CaseStudy.services.Impl;

import CaseStudy.models.person.Customer;
import CaseStudy.services.Interface.CustomerService;
import CaseStudy.utils.DateException;
import CaseStudy.utils.MatchesCheck;
import CaseStudy.utils.WriteReadFile;

import java.text.ParseException;
import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Customer> arrayCustomer=new LinkedList<>();
    private static final String[] arrayType={null,"Diamond","Platinium","Gold","Silver","Member"};
    private static final String[] arraySet={"Khác","Nam","Nữ"};


    @Override
    public void editCustomer() {
        try{
            if(arrayCustomer.size()==0)
            {
                System.out.println("Employee list is empty!");
                return;
            }
            disPlay();
            System.out.println();
            System.out.print("Edit Customer ID: ");
            int id=Integer.parseInt(scanner.nextLine());
            int index=indexCustomer(id);
            if(index!=-1)
            {
                System.out.println(arrayCustomer.get(index).toString());
                System.out.println("Edit information:");
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
                System.out.println("Type: 1.Diamond  2.Platinium  3.Gold  4.Silver  5.Member");
                int indexType;
                while (true) {
                    System.out.print("Choose your type: ");
                    String indexTypeStr = scanner.nextLine();
                    if (MatchesCheck.checkOneNumber(indexTypeStr))
                    {
                        indexType=Integer.parseInt(indexTypeStr);
                        if(indexType>=1 && indexType<=5)
                            break;
                    }
                    System.out.println("Please re-enter room!");
                }

                String loaiKhach=arrayType[indexType];
                System.out.print("Address: ");
                String address=scanner.nextLine();
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
                arrayCustomer.set(index,new Customer(id,fullname,birthDay,set,phonenumber,email,cccd,loaiKhach,address));
                WriteReadFile.writeToFile("D:\\Codegym\\module2\\src\\CaseStudy\\data\\customer.cvs",arrayCustomer);
                System.out.println("Update successful!");
            }
            else {
                System.out.println("This customer code does not exist!");
            }
        }catch (Exception e)
        {
            System.out.println("Input data is wrong!");
        }
    }

    private int indexCustomer(int id)
    {
        int index=-1;
        for (int i=0; i<arrayCustomer.size(); i++)
        {
            if (id==arrayCustomer.get(i).getCustomerCode())
            {
                index=i;
                break;
            }
        }
        return index;
    }

    public Customer getCustomer(int id)
    {
        int index=indexCustomer(id);
        if(index!=-1)
        {
            return arrayCustomer.get(index);
        }
        return null;
    }

    @Override
    public void addNew(Customer customer) {
        if(customer!=null)
        {
            arrayCustomer.add(customer);
            VoucherServices.addToVoucher(customer.getCustomerCode());
            System.out.println("More success!");
        }
        else
        {
            System.out.println("Unsuccessful!");
        }
        Collections.sort(arrayCustomer, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        WriteReadFile.writeToFile("D:\\Codegym\\module2\\src\\CaseStudy\\data\\customer.cvs",arrayCustomer);
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
        String idStr;
        while (true)
        {
            System.out.print("ID: ");
            idStr=scanner.nextLine();
            if(MatchesCheck.checkId(idStr))
                break;
            System.out.println("Format ID: 1xxx");
        }
        int id=Integer.parseInt(idStr);
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
                int index=Integer.parseInt(indexSet);
                if(index>=0 && index<=2)
                {
                    set=arraySet[index];
                    break;
                }
                System.out.println("Please choose again!");
            }
        }
        System.out.println("Type: 1.Diamond  2.Platinium  3.Gold  4.Silver  5.Member");
        int indexType;
        while (true) {
            System.out.print("Choose your type: ");
            String indexTypeStr = scanner.nextLine();
            if (MatchesCheck.checkOneNumber(indexTypeStr))
            {
                indexType=Integer.parseInt(indexTypeStr);
                if(indexType>=1 && indexType<=5)
                    break;
            }
                System.out.println("Please re-enter room!");
        }

        String loaiKhach=arrayType[indexType];
        System.out.print("Address: ");
        String address=scanner.nextLine();
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
        return new Customer(id,fullname,birthDay,set,phonenumber,email,cccd,loaiKhach,address);
    }

    public static int getSize()
    {
        return arrayCustomer.size();
    }

    public static boolean isEmpty()
    {
        return arrayCustomer.isEmpty();
    }
    public static void setArrayCustomer(List<Customer> list)
    {
        arrayCustomer=list;
    }

    public static void readArrayCostomer(String path)
    {
        WriteReadFile.readDataFromFileCus(path,arrayCustomer);
    }
}

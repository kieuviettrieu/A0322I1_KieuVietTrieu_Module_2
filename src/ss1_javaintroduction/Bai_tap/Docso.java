package ss1_javaintroduction.Bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Docso {
    public static void main(String[] args) {
        Docso docso=new Docso();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter is number: ");
        String number=sc.nextLine();
        String str="";
        if(number.length()==1)
        {
            str=docso.c1(number.charAt(0));
        }
        else
            if(Integer.parseInt(number)<20 && Integer.parseInt(number)>=10)
            {
                str=docso.haiSo(number);
            }
            else
            if(number.length()==2 && Integer.parseInt(number)>=20)
            {
                str+=docso.c2(number.charAt(0));
                if(number.charAt(1)!='0') str+="-"+docso.c1(number.charAt(1));
            }
            else
                if(number.length()==3)
                {
                    str+=docso.c1(number.charAt(0))+" Hundred";
                    if(number.charAt(1)=='0') str+=" "+docso.c1(number.charAt(2));
                    else
                        if(number.charAt(1)=='1') str+=" and "+docso.haiSo(number.substring(1));
                        else {
                            str+=" and "+docso.c2(number.charAt(1));
                            if(number.charAt(1)!='0') str+="-"+docso.c1(number.charAt(2));
                        }
                }
                else
                {
                    str+="This version is not supported yet";
                }
        System.out.println("-->"+str);
    }

    private String chuyenDoi(String s)
    {
        if(s.charAt(s.length()-1)=='t')
        {
            return s+"een";
        }else
        {
            return s+"teen";
        }
    }

    public String c1(char number)
    {
        String str="";
        switch (number)
        {
            case '0':
                break;
            case '1': str+="One";
                break;
            case '2': str+="Two";
                break;
            case '3': str+="Three";
                break;
            case '4': str+="Four";
                break;
            case '5': str+="Five";
                break;
            case '6': str+="Six";
                break;
            case '7': str+="Seven";
                break;
            case '8': str+="Eight";
                break;
            case '9': str+="Nine";
                break;
            default: str+="out of ability";
                break;
        }
        return str;
    }

    public String c2(char number)
    {
        String str="";
        switch (number)
        {
            case '2': str+="Twenty";
                break;
            case '3': str+="Thirty";
                break;
            case '4': str+="Forty";
                break;
            case '5': str+="Fifty";
                break;
            case '6': str+="Sixty";
                break;
            case '7': str+="Seventy";
                break;
            case '8': str+="Eighty";
                break;
            case '9': str+="Ninety";
                break;
        }
        return str;
    }

    public String haiSo(String number)
    {
        String str="";
        switch (number)
        {
            case "10": str+="Ten";
                break;
            case "11": str+="Eleven";
                break;
            case "12": str+="Twelve";
                break;
            case "13": str+="Thirteen";
                break;
            case "15": str+="Fiffteen";
                break;
            case "14":
            case "16":
            case "17":
            case "18":
            case "19":
                str+=chuyenDoi(c1(number.charAt(1)));
                break;
        }
        return str;
    }
}


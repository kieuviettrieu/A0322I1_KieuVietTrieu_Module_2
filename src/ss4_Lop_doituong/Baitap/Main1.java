package ss4_Lop_doituong.Baitap;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a,b,c;
        System.out.print("Enter a,b,c: ");
        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        QuadraticEquation quadraticEquation=new QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant()>0)
        {
            System.out.println("The equation has two roots "+quadraticEquation.getRoot1()+" and "+
                    quadraticEquation.getRoot2());
        }
        else
            if(quadraticEquation.getDiscriminant()==0)
            {
                System.out.println("The equation has one root "+quadraticEquation.getRoot1());
            }
            else
            {
                System.out.println("The equation has no roots");
            }
    }
}

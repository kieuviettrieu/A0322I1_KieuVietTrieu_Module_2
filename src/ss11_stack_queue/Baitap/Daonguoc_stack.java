package ss11_stack_queue.Baitap;

import java.util.Stack;

public class Daonguoc_stack {

    public static void main(String[] args) {
        System.out.println("Ban đầu:");
        System.out.println("1 2 3 4 5 6 7 8 9 10");
        System.out.println("Một Hai Ba Bốn Năm Sáu Bảy Tám Chín Mười");
        Stack<Integer> stackInt=new Stack<Integer>();
        for (int i=1; i<=10; i++)
        {
            stackInt.push(i);
        }

        String str="Một Hai Ba Bốn Năm Sáu Bảy Tám Chín Mười";
        String[] arrayStr=str.split(" ");
        Stack<String> stackStrings=new Stack<>();
        for (int i=0; i<arrayStr.length; i++)
        {
            stackStrings.push(arrayStr[i]);
        }

        System.out.println("Thay đổi: ");
        while (!stackInt.empty())
        {
            System.out.print(stackInt.pop()+" ");
        }

        System.out.println();
        while (!stackStrings.empty())
        {
            System.out.print(stackStrings.pop()+" ");
        }

    }
}

package ss11_stack_queue.Baitap;

import java.util.Stack;

public class Optional_stack_nhiphan {
    public static void main(String[] args) {
        Stack<Integer> stackInteger=new Stack<>();
        int numberThapPhan=111;
        int copyNumber=numberThapPhan;
        while (copyNumber>0)
        {
            stackInteger.push(copyNumber%2);
            copyNumber/=2;
        }

        System.out.print(numberThapPhan+" có hệ nhị phân: ");
        while (!stackInteger.empty())
        {
            System.out.print(stackInteger.pop());
        }
    }
}

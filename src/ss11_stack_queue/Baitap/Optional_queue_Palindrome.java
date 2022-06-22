package ss11_stack_queue.Baitap;

import sun.misc.Queue;

import java.util.Stack;

public class Optional_queue_Palindrome {

    public static void main(String[] args) throws InterruptedException {
        Stack<String> stackPalindrome=new Stack<>();
        Queue<String> queuePalindrome=new Queue<>();
        String string="Able was I ere I saw Elba";
        String[] arrayStrings=string.split(" ");
        for (int i=0; i<arrayStrings.length; i++)
        {
            stackPalindrome.push(arrayStrings[i]);
            queuePalindrome.enqueue(arrayStrings[i]);
        }
        boolean checkPalindrome=true;
        while (!stackPalindrome.isEmpty())
        {
            if(stackPalindrome.pop().equals(queuePalindrome.dequeue()))
            {
                checkPalindrome=false;
                break;
            }
        }
        if(checkPalindrome)
        {
            System.out.println("String is Palindrome");
        }
        else
        {
            System.out.println("String is not Palindrome");
        }
    }
}

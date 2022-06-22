package ss11_stack_queue.Baitap;

public class Solution {
    private static Queue queue=new Queue();
    public static void main(String[] args) {
        enQueue();
        System.out.println();
        deQueue();
    }

    public static void enQueue()
    {
        System.out.print("Input: ");
        for (int i=1; i<10; i++)
        {
            queue.enqueue(i);
            System.out.print(i+" ");
        }
    }

    public static void deQueue()
    {
        System.out.print("Output: ");
        do {
            Node node=queue.dequeue();
            if(node==null) break;
            System.out.print(node.key+" ");
        }while (true);
    }

}

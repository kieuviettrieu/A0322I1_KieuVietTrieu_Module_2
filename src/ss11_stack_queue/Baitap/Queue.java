package ss11_stack_queue.Baitap;


public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.link = temp;
        this.rear = temp;
    }

    public Node dequeue() {
        if (this.front == null)
            return null;
        Node temp = this.front;
        this.front = this.front.link;
        if (this.front == null)
            this.rear = null;
        return temp;
    }
}

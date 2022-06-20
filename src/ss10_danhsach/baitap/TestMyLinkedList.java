package ss10_danhsach.baitap;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList=new MyLinkedList<>();
        myLinkedList.addLast("Hanoi");
        myLinkedList.addLast("Danang");
        myLinkedList.addLast("Quangnam");
        myLinkedList.addLast("Saigon");
        myLinkedList.add(2,"Nhatrang");
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(2));
        for (int i=0; i<myLinkedList.size(); i++)
        {
            System.out.print(myLinkedList.get(i)+", ");
        }

        System.out.println();
        System.out.println("Xóa phần tử index 3");
        myLinkedList.remove(3);
        for (int i=0; i<myLinkedList.size(); i++)
        {
            System.out.print(myLinkedList.get(i)+", ");
        }
    }
}

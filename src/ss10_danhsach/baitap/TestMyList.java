package ss10_danhsach.baitap;

public class TestMyList {
    public static void main(String[] args) {
        MyList<String> myList=new MyList<>();
        myList.add("DaNang");
        myList.add("HaNoi");
        myList.add("SaiGon");
        myList.add("NhaTrang");
        myList.add("GiaLai");

        System.out.println(myList.size());
        for (int i=0; i<myList.size(); i++)
        {
            System.out.print(myList.get(i)+" ");
        }
        System.out.println();
        System.out.println("Đã xóa: "+myList.remove(2));
        for (int i=0; i<myList.size(); i++)
        {
            System.out.print(myList.get(i)+" ");
        }
    }
}

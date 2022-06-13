package ss4_Lop_doituong.Baitap;

import javafx.scene.paint.Stop;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Stopwatch stopwatch=new Stopwatch();
        stopwatch.start();
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0; i<50000; i++)
        {
            int a=i*(i-1)+2-1;
            arrayList.add(i);
        }
        for (int i=100000; i>50000; i--)
        {
            arrayList.add(i);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        stopwatch.stop();
        System.out.println("Milisecond giây đo được: "+stopwatch.getElapsedTime());
    }
}

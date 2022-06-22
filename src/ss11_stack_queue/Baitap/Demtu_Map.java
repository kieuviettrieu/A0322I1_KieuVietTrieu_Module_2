package ss11_stack_queue.Baitap;

import java.util.TreeMap;

public class Demtu_Map {
    public static void main(String[] args) {
        TreeMap<String,Integer> treeMapTu=new TreeMap<>();
        String str="mot hai ba anh bo doi cong mot an hai ba bon hai bay di dau";
        String[] arrayStrings=str.split(" ");
        for(int i=0; i<arrayStrings.length; i++)
        {
            if(treeMapTu.containsKey(arrayStrings[i]))
            {
                int newValue=treeMapTu.get(arrayStrings[i]);
                treeMapTu.put(arrayStrings[i],++newValue);
            }else {
                treeMapTu.put(arrayStrings[i],1);
            }
        }
        System.out.println(treeMapTu);

    }
}

package ss13_thuat_toan_timkiem.baitap;

public class BinarySearch_dequi {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearch(int[] list, int key)
    {
        return binarySearch(list,key,0,list.length-1);
    }

    private static int binarySearch(int[] list, int key,int first,int last)
    {
        if(list[first]==key)
        {
            return first;
        }
        if(list[last]==key)
        {
            return last;
        }
        int second=(first+last)/2;
        if(list[second]==key)
        {
            return second;
        }
        if(first==last)
        {
            return -1;
        }
        if(key<list[second])
        {
            return binarySearch(list,key,first+1,second-1);
        }
        else
        {
            return binarySearch(list,key,second+1,last-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));  /* 0 */
        System.out.println(binarySearch(list, 11)); /* 4 */
        System.out.println(binarySearch(list, 79)); /*12 */
        System.out.println(binarySearch(list, 1));  /*-1 */
        System.out.println(binarySearch(list, 5));  /*-1 */
        System.out.println(binarySearch(list, 80)); /*-1 */
    }
}

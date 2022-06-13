package ss2_vonglap.bai_tap;

public class Nguyento2 {
    public static void main(String[] args) {
        Nguyento2 nto=new Nguyento2();
        int i=2;
        System.out.println("Các số nguyên tố nhỏ hơn 100: ");
        while (i<100)
        {
            if(nto.kTranguyento(i))
            {
                System.out.print(i+" ");
            }
            i++;
        }
    }

    private boolean kTranguyento(int x)
    {
        if(x<2) return false;
        for (int i=2; i<=Math.sqrt(x); i++)
        {
            if(x%i==0) return false;
        }
        return true;
    }
}

package ss2_vonglap.bai_tap;

public class Nguyento {
    public static void main(String[] args) {
        Nguyento nto=new Nguyento();
        int dem=0;
        int i=2;
        System.out.println("20 số nguyên tố đầu tiên: ");
        while (dem<20)
        {
            if(nto.kTranguyento(i))
            {
                System.out.print(i+" ");
                dem++;
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

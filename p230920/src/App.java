import java.util.Random;

public class App {
    public enum art { 클로버, 하트, 다이아, 스페이드 }
    public enum char_num { J, Q, K }

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int a_num = random.nextInt(13)%13;
        int b_num = random.nextInt(13)%13;
        int a_art = random.nextInt(4)%4;
        int b_art = random.nextInt(4)%4;
        String a = "a";
        String b = "b";
        int aimsi;
        int bimsi;
        
        while(a_num==b_num && a_art==b_art)
        {
            a_num = random.nextInt(13)%13;
            b_num = random.nextInt(13)%13;
            a_art = random.nextInt(4)%4;
            b_art = random.nextInt(4)%4;
        };
        
        for (art Art : art.values())
        {
            if(Art.ordinal()==a_art)
            {
                a = Art.name();
            }
        }     
        for (art Art : art.values())
        {
            if(Art.ordinal()==b_art)
            {
                b = Art.name();
            }
        }    

        if(a_num<9 && a_num!=0)
        {
            aimsi = a_num+1;
            System.out.print("A는 " + aimsi + a);
            if(b_num<9 && b_num!=0)
            {
                bimsi = b_num+1;
                System.out.print(" B는 "+ bimsi + b);
            }else if(b_num>9)
            {
                if(b_num==10)
                {
                    System.out.print(" B는 j" + b);
                }else if(b_num==11)
                {
                    System.out.print(" B는 q" + b);
                }else
                {
                    System.out.print(" B는 k" + b);
                }
            }else
            {
                System.out.print(" B는 ACE");
            }
        }else{
            if(a_num==10)
            {
                System.out.print("A는 j" + a);
            }else if(b_num==11)
            {
                System.out.print("A는 q" + a);
            }else if(b_num==12)
            {
                System.out.print("A는 k" + a);
            }else
            {
                System.out.print("A는 ACE" + a);
            }
            if(b_num<9 && b_num!=0)
            {
                bimsi = b_num+1;
                System.out.print(" B는 "+ bimsi + b);
            }else if(b_num>9 || b_num==0)
            {
                if(b_num==10)
                {
                    System.out.print(" B는 j" + b);
                }else if(b_num==11)
                {
                    System.out.print(" B는 q" + b);
                }else if(b_num==12)
                {
                    System.out.print(" B는 k" + b);
                }else
                {
                    System.out.print(" B는 ACE" + b);
                }
            }
        }

        if(a_num==0 && a_num!=b_num)
        {
            System.out.println(" A가 이겼다.");
        }else if(b_num==0 && b_num!=a_num)
        {
            System.out.println(" B가 이겼다.");
        }
        else if(a_num>b_num)
        {
            System.out.println(" A가 이겼다.");
        }else if(a_num<b_num)
        {
            System.out.println(" B가 이겼다.");
        }else{
            if(a_art>b_art)
            {
                System.out.println(" A가 이겼다.");
            }else if(a_art<b_art)
            {
                System.out.println(" B가 이겼다.");
            }
        }
    }
}
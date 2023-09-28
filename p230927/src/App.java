import java.util.Random;

class Card
{
    public enum art { 클로버, 하트, 다이아, 스페이드 }
    public enum char_num { J, Q, K, ACE }
    public String name;
    public int num;
    public int imsi_art;
    public int imsi_num;
    public String printArt;
    public String printNum;
    Random random = new Random();
    public void getName(String a)
    {
        name = a;
    }
    public void print_card()
    {
        if(imsi_num <= 9)
        {
            System.out.println("값" + printArt + (imsi_num+1));
        }else{
            System.out.println("값" + printArt + printNum);
        }
    }
    public void numCard(int CardNum)
    {
        while(num/4 != CardNum-1)
        {
            num = random.nextInt(52);
        }
        imsi_art = num%4;
        imsi_num = num/4;
        if(imsi_num>=9)
        {
            for (char_num Num : char_num.values())
            {
                if(Num.ordinal()==(imsi_num-9))
                {
                   printNum= Num.name();
                }
            }
        }
        for (art Art : art.values())
        {
            if(Art.ordinal()==imsi_art)
            {
                printArt= Art.name();
            }
        }
    }
    public Card(int CardNum)
    {
        while(num/4 != CardNum-1)
        {
            num = random.nextInt(52);
            if(CardNum == 1)
            {
                if(num/4 == 12)
                {
                    break;
                }
            }
        }
        imsi_art = num%4;
        imsi_num = num/4;
        if(imsi_num>=9)
        {
            for (char_num Num : char_num.values())
            {
                if(Num.ordinal()==(imsi_num-9))
                {
                   printNum= Num.name();
                }
            }
        }
        for (art Art : art.values())
        {
            if(Art.ordinal()==imsi_art)
            {
                printArt= Art.name();
            }
        }
    }
    public Card(String type, int n)
    {
        imsi_num = n - 1;
        this.printArt = type;
        int type_check = 0;
        if(type == "클로버")
        {
            type_check = 0;
        }else if(type == "하트")
        {
            type_check = 1;
        }else if(type == "다이아")
        {
            type_check = 2;
        }else if(type == "스페이드")
        {
            type_check = 3;
        }
        this.num = num * 4 + type_check;
        if(n>=9)
        {
            for (char_num Num : char_num.values())
            {
                if(Num.ordinal()==(n-9))
                {
                   printNum= Num.name();
                }
            }
        }
        for (art Art : art.values())
        {
            if(Art.ordinal()==type_check)
            {
                printArt= Art.name();
            }
        }
    }
    public Card(String type)
    {
        this.printArt = type;
        int type_check = 0;
        if(type == "클로버")
        {
            type_check = 0;
        }else if(type == "하트")
        {
            type_check = 1;
        }else if(type == "다이아")
        {
            type_check = 2;
        }else if(type == "스페이드")
        {
            type_check = 3;
        }else    //숫자인 경우
        {
            if(type == "J")
            {
                numCard(11);
            }else if(type == "Q")
            {
                numCard(12);
            }else if(type == "K")
            {
                numCard(13);
            }else  //ace
            {
                numCard(14);
            }
        }
        while(num%4 != type_check)
        {
            num = random.nextInt(52);
        }
        imsi_art = num%4;
        imsi_num = num/4;

        if(imsi_num>=9)
        {
            for (char_num Num : char_num.values())
            {
                if(Num.ordinal()==(imsi_num-9))
                {
                   printNum= Num.name();
                }
            }
        }
    }
    public Card() {
        num = random.nextInt(52);
        imsi_art = num%4;
        imsi_num = num/4;
        for (art Art : art.values())
        {
            if(Art.ordinal()==imsi_art)
            {
                printArt= Art.name();
            }
        }
        if(imsi_num>=9)
        {
            for (char_num Num : char_num.values())
            {
                if(Num.ordinal()==(imsi_num-9))
                {
                   printNum= Num.name();
                }
            }
        }
    }
}


public class App {
    public static void main(String [] args) {
        Card card1 = new Card();
        Card card2 = new Card(10);
        Card card3 = new Card("스페이드");
        Card card4 = new Card("클로버", 10);

        card1.print_card();
        card2.print_card();
        card3.print_card();
        card4.print_card();
    }
}

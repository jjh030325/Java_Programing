import java.util.Random;

public class App {
    public enum art { 클로버, 하트, 다이아, 스페이드 }
    public enum char_num { J, Q, K, ACE }
    public static class Card
    {
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
        public void getCard() {
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
        public void CardBattle(Card card2) {
            if(imsi_num < 9)
            {
                System.out.println(name + "의 값" + printArt + (imsi_num+1));
            }else{
                System.out.println(name + "의 값" + printArt + printNum);
            }
            if(card2.imsi_num < 9)
            {
                System.out.println(card2.name + "의 값" + card2.printArt + (card2.imsi_num+1));
            }else{
                System.out.println(card2.name + "의 값" + card2.printArt + card2.printNum);
            }
            if(num > card2.num)
            {
                System.out.println(name + "의 승리");
            }else{
                System.out.println(card2.name + "의 승리");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Card card1 = new Card();
        Card card2 = new Card();

        card1.getName("1번카드");
        card2.getName("2번카드");
        card1.getCard();
        card2.getCard();
        while(card1.num == card2.num)
        {
            card2.getCard();
        };

        card1.CardBattle(card2);
    }
}

import java.util.Random;

abstract class Card
{
    int type;
    int number;
    String Strtype;
    String Strnumber;
    abstract public void draw();
    public void printCard()
    {
        System.out.println(Strtype + Strnumber);
    }
    @Override
    public String toString() {
        return Strtype + Strnumber;
    }
    @Override
    public boolean equals(Object obj) {
        Card p = (Card)obj;
        if(type == p.type && number == p.number)
            return true;
        else return false;
    }
}
class OneCard extends Card
{
    // 가능한 카드 타입
    private static final String[] cardTypes = {"스페이드", "다이아몬드", "하트", "클로버"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public void draw()
    {
        Random random = new Random();
        this.type = random.nextInt(4);
        this.number = random.nextInt(13);
        this.Strtype = cardTypes[type];
        this.Strnumber = cardNumbers[number];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        OneCard onecard1 = new OneCard();
        OneCard onecard2 = new OneCard();
        int count = 0;
        double ans = 1;
        
        for(int i=0;i<100;i++)
        {
            onecard1.draw();
            while(onecard1!=onecard2)
            {
                count++;
                onecard2.draw();
                if(onecard1.equals(onecard2))
                {
                    System.out.println(onecard1 + " " + onecard2);
                    break;
                }
            }
        }
        
        System.out.println("같은 카드가 100번 나올 때까지 뽑은 수 : " + count);
        ans /= count/100;
        System.out.println("같은 카드가 나올 확률 : " + ans);
    }
}

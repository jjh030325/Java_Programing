import java.util.Random;
import java.util.ArrayList;

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
        if(type == p.type || number == p.number)
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

    OneCard()
    {
        draw();
        printCard();
    }

    public void draw()
    {
        Random random = new Random();
        this.type = random.nextInt(4);
        this.number = random.nextInt(13);
        this.Strtype = cardTypes[type];
        this.Strnumber = cardNumbers[number];
    }
}

class player
{
    
    String name;
    OneCard now;
    private ArrayList<OneCard> list = new ArrayList<>();
    player(String name)
    {
        this.name = name;
        for(int i=0;i<7;i++)
        {
            list.add(new OneCard());
            //list.get(i).printCard();
        }
    }
    public int getindex()
    {
        return list.size();
    }
    public OneCard First()
    {
        return list.get(0);
    }
    public OneCard Play(OneCard card)
    {
        for(int i=0;i<list.size();i++)
        {
            if(card.equals(list.get(i)))
            {
                list.get(i).printCard();
                now = list.get(i);
                list.remove(i);
                if(list.size()==0)
                {
                    System.out.println(name + " Win!");
                }
                return now;
            }
        }
        list.add(new OneCard());
        return card;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        player p1 = new player("player1");
        player p2 = new player("player2");

        OneCard now = p1.First();
        while(true)
        {
            System.out.println("p1 turn");
            now = p1.Play(now);
            if(p1.getindex() == 0)
            {
                break;
            }
            System.out.println("p2 turn");
            now = p2.Play(now);
            if(p2.getindex() == 0)
            {
                break;
            }
        }
    }
}

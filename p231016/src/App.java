import java.util.Random;

class Card
{
    private String type;
    private String number;
    // 가능한 카드 타입
    private static final String[] cardTypes = {"a","b","c","d"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

    public Card()
    {
        Random random = new Random();
        this.type = cardTypes[random.nextInt(cardTypes.length)];
        this.number = cardNumbers[random.nextInt(cardNumbers.length)];
    }
    public void showCard() {
        System.out.println(type + " " + number);
    }
}

class OneCard extends Card
{
    private String type;
    private String number;
    // 가능한 카드 타입
    private static final String[] cardTypes = {"스페이드", "다이아몬드", "하트", "클로버"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public OneCard()
    {
        Random random = new Random();
        this.type = cardTypes[random.nextInt(cardTypes.length)];
        this.number = cardNumbers[random.nextInt(cardNumbers.length)];
    }
    public void showCard() {
        System.out.println(type + " " + number);
    }
}

class uno extends Card
{
    private String type;
    private String number;
    // 가능한 카드 타입
    private static final String[] cardTypes = {"빨강", "노랑", "초록", "파랑"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "SKIP", "REVERSE", "DRAW"};

    public uno()
    {
        Random random = new Random();
        this.type = cardTypes[random.nextInt(cardTypes.length)];
        this.number = cardNumbers[random.nextInt(cardNumbers.length)];
    }
    public void showCard() {
        System.out.println(type + " " + number);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Card card = new Card();
        OneCard oneCard = new OneCard();
        uno uno = new uno();

        Card deck[] = new Card[3];

        deck[0] = card;
        deck[1] = oneCard;
        deck[2] = uno;

        for(int i=0;i<3;i++)
        {
            deck[i].showCard();
        }
    }
}

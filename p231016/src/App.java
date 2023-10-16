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
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        OneCard oneCard1 = new OneCard();
        OneCard oneCard2 = new OneCard();
        OneCard oneCard3 = new OneCard();
        uno uno1 = new uno();
        uno uno2 = new uno();
        uno uno3 = new uno();

        Card deck[] = new Card[9];

        deck[0] = card1;
        deck[1] = card2;
        deck[2] = card3;
        deck[3] = oneCard1;
        deck[4] = oneCard2;
        deck[5] = oneCard3;
        deck[6] = uno1;
        deck[7] = uno2;
        deck[8] = uno3;
        
        for(int i=0;i<9;i++)
        {
            deck[i].showCard();
        }
    }
}

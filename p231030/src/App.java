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
}
class OneCard extends Card implements Comparable<OneCard>
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
    @Override
    public int compareTo(OneCard other) {
        if (this.number == other.number) {
            return Integer.compare(this.type, other.type);
        } else {
            return Integer.compare(this.number, other.number);
        }
    }
}
class uno extends Card implements Comparable<uno>
{
    // 가능한 카드 타입
    private static final String[] cardTypes = {"빨강", "노랑", "초록", "파랑"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "SKIP", "REVERSE", "DRAW"};
    public void draw()
    {
        Random random = new Random();
        this.type = random.nextInt(4);
        this.number = random.nextInt(13);
        this.Strtype = cardTypes[type];
        this.Strnumber = cardNumbers[number];
    }
    @Override
    public int compareTo(uno other) {
        if (this.number == other.number) {
            return Integer.compare(this.type, other.type);
        } else {
            return Integer.compare(this.number, other.number);
        }
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        OneCard oneCard1 = new OneCard();
        OneCard oneCard2 = new OneCard();
        uno uno1 = new uno();
        uno uno2 = new uno();

        oneCard1.draw();
        oneCard2.draw();
        uno1.draw();
        uno2.draw();
        
        oneCard1.printCard();
        oneCard2.printCard();
        uno1.printCard();
        uno2.printCard();

        // OneCard 비교
        if (oneCard1.compareTo(oneCard2) > 0) {
            System.out.println("oneCard1이 oneCard2보다 더 큽니다.");
        } else if (oneCard1.compareTo(oneCard2) < 0) {
            System.out.println("oneCard2가 oneCard1보다 더 큽니다.");
        } else {
            System.out.println("두 카드는 같습니다.");
        }

        // uno 비교
        if (uno1.compareTo(uno2) > 0) {
            System.out.println("uno1이 uno2보다 더 큽니다.");
        } else if (uno1.compareTo(uno2) < 0) {
            System.out.println("uno2가 uno1보다 더 큽니다.");
        } else {
            System.out.println("두 카드는 같습니다.");
        }
    }
}

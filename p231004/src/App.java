import java.util.Random;

class Card {
    private String type;
    private String number;
    private int index;
    private int typenum;
    private int numnum;

    // 가능한 카드 타입
    private static final String[] cardTypes = {"스페이드", "다이아몬드", "하트", "클로버"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public int howindex()
    {
        return index;
    }

    public Card(Card other) {
        this.type = other.type;
        this.number = other.number;
        this.index = other.index;
        this.typenum = other.typenum;
        this.numnum = other.numnum;
    }

    public Card() {                                //전부 랜덤하게 카드를 생성
        Random random = new Random();
        this.typenum = random.nextInt(cardTypes.length);
        this.type = cardTypes[typenum];
        this.numnum = random.nextInt(cardNumbers.length);
        this.number = cardNumbers[numnum];
        this.index = numnum * 4 + typenum;
    }

    public Card(String typeOrNumber) {
        if (isCardType(typeOrNumber)) {            //타입이 입력된 경우
            this.type = typeOrNumber;
            Random random = new Random();
            this.numnum = random.nextInt(cardNumbers.length);
            this.number = cardNumbers[numnum];
            for(int i=0;i<cardTypes.length;i++)
            {
                if(type == cardTypes[i])
                {
                    typenum = i;
                    break;
                }
            }
        } else {                                   //숫자가 입력된 경우
            this.typenum = new Random().nextInt(cardTypes.length);
            this.type = cardTypes[typenum];
            this.number = typeOrNumber;
            for(int i=0;i<cardNumbers.length;i++)
            {
                if(type == cardNumbers[i])
                {
                    numnum = i;
                    break;
                }
            }
        }
        this.index = numnum * 4 + typenum;
    }

    public Card(String type, String number) {     //타입과 숫자 둘 다 입력받은 경우
        this.type = type;
        this.number = number;
        for(int i=0;i<cardTypes.length;i++)
        {
            if(type == cardTypes[i])
            {
                typenum = i;
                break;
            }
        }
        for(int i=0;i<cardNumbers.length;i++)
        {
            if(type == cardNumbers[i])
            {
                numnum = i;
                break;
            }
        }
        this.index = numnum * 4 + typenum;
    }

    private boolean isCardType(String input) {
        for (String cardType : cardTypes) {
            if (cardType.equals(input)) {          //카드 타입중 같은 것이 있는 경우 타입이 입력된 것.
                return true;
            }
        }
        return false;                              //카드 타입중 같은 것이 없는 경우 숫자가 입력된 것.
    }

    // 카드 정보 출력
    public void displayCard() {
        System.out.println("카드 종류: " + type + number);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Card[] deckCards = new Card[10];
        Card[] Copydeck = new Card[10];
        int[] deckChecks = new int[10];
        for(int i=0;i<10;i++)
        {
            deckCards[i] = new Card();
            deckChecks[i] = deckCards[i].howindex();
        }

        for(int i=0;i<10;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(deckChecks[j]<deckChecks[i])
                {
                    int tmp = deckChecks[i];
                    deckChecks[i] = deckChecks[j];
                    deckChecks[j] = tmp;
                }
            }
        }

        System.out.println("정리안된 카드");
        for(int i=0;i<10;i++)
        {
            deckCards[i].displayCard();
        }
        System.out.println("정리된 카드");
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(deckChecks[i]==deckCards[j].howindex())
                {
                    Copydeck[i] = new Card(deckCards[j]);
                    Copydeck[i].displayCard();
                    break;
                }
            }
        }
    }
}

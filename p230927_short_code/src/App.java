import java.util.Random;

class Card {
    private String type;
    private String number;

    // 가능한 카드 타입
    private static final String[] cardTypes = {"스페이드", "다이아몬드", "하트", "클로버"};
    
    // 가능한 카드 숫자
    private static final String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Card() {                                //전부 랜덤하게 카드를 생성
        Random random = new Random();
        this.type = cardTypes[random.nextInt(cardTypes.length)];
        this.number = cardNumbers[random.nextInt(cardNumbers.length)];
    }

    public Card(String typeOrNumber) {
        if (isCardType(typeOrNumber)) {            //타입이 입력된 경우
            this.type = typeOrNumber;
            Random random = new Random();
            this.number = cardNumbers[random.nextInt(cardNumbers.length)];
        } else {                                   //숫자가 입력된 경우
            this.type = cardTypes[new Random().nextInt(cardTypes.length)];
            this.number = typeOrNumber;
        }
    }

    public Card(String type, String number) {     //타입과 숫자 둘 다 입력받은 경우
        this.type = type;
        this.number = number;
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
        System.out.println("카드 타입: " + type);
        System.out.println("카드 숫자: " + number);
    }

    public static void main(String[] args) {
        // 다양한 생성 방법으로 카드 생성 및 출력
        Card randomCard = new Card();
        Card numberCard = new Card("7");
        Card typeCard = new Card("다이아몬드");
        Card fixedCard = new Card("하트", "K");

        System.out.println("랜덤한 카드:");
        randomCard.displayCard();

        System.out.println("\n고정된 숫자 카드:");
        numberCard.displayCard();

        System.out.println("\n고정된 타입 카드:");
        typeCard.displayCard();

        System.out.println("\n고정된 타입과 숫자 카드:");
        fixedCard.displayCard();
    }
}

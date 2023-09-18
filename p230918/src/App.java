import java.util.Scanner;

public class App {
    public enum Week { 월, 화, 수, 목, 금, 토, 일 }
    public static void main(String[] args) throws Exception {
        Scanner weekScanner = new Scanner(System.in);
        int num = weekScanner.nextInt();
        num %= 7;
        String ans = "월";
        for (Week day : Week.values()) // 반복될 때마다 day는 월, 화, 수, 목, 금, 토, 일로 설정
            if(day.ordinal()==num)
            {
                ans = day.name();
            }

        if(num<5)
        {
            System.out.println("오늘은 " + ans + "요일입니다. 주중이고, 자바를 공부합니다.");
        }
        else{
            System.out.println("오늘은 " + ans + "요일입니다. 주말이고, 운동을 합니다.");
        }
        
        weekScanner.close();
    }
}

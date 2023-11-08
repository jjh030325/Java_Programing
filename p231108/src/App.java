import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner Scanner = new Scanner(System.in);
        String[] fruits = { "strawberry", "watermelon", "apple", "orange", "banana", "blueberry" };
        int index = (new Random()).nextInt(fruits.length);
        String solution = fruits[index];    //답
        char[] printWord = {'_','_','_','_','_','_','_','_','_','_','_',};
        int count = solution.length();

        System.out.print("Game : ");
        for(int i=0;i<solution.length();i++)
        {
            System.out.print(printWord[i]);
        }
        System.out.println();
        do
        {
            System.out.print("Input a character : ");
            String alpa = Scanner.next();
            boolean nocheck = true;

            if(alpa.compareTo(solution) == 0)
            {
                count = 0;
            }else if(alpa.length() == 1){
                for(int i=0;i<solution.length();i++)
                {
                    if(solution.charAt(i)==alpa.charAt(0))
                    {
                        printWord[i] = solution.charAt(i);
                        count-=1;
                        nocheck = false;
                    }
                }
                if(nocheck == true)
                {
                    nocheck = false;
                    System.out.println("No such character!!");
                }
                System.out.print("Game : ");
                for(int i=0;i<solution.length();i++)
                {
                    System.out.print(printWord[i]);
                }
                System.out.println();
            }
            
            if(count<=0)
            {
                System.out.println("Success!!");
                break;
            }
        }while(true);

        Scanner.close();
    }
}

/*
1. 6개의 단어 (Strawberry, Watermelon, Apple, Orange, Banana, Blueberry)중 임의의 1개가 선택됨
2. 사용자는 캐릭터를 입력하여 현재 선택된 단어가 무엇인지 찾아야 함
3. 정답을 맞추면 프로그램이 종료됨
 */
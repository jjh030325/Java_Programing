import java.util.Random;
import java.util.Scanner;

public class App {
    public enum art { 클로버, 하트, 다이아, 스페이드 }
    public enum char_num { J, Q, K, ACE }
    //1클로버, 1하트, 1다이아, 1스페이드 순으로 진행
    //(art-1)*4 + art = num
    public static void main(String[] args) throws Exception {
        Scanner Scanner = new Scanner(System.in);
        int num = Scanner.nextInt();
        Random random = new Random();
        int []art_and_num = new int [num];
        boolean check = false;
        String printArt = "a";
        String printNum = "a";
        int winner = 0;
        int winnerCount = 0;

        for(int i=0;i<num;i++)
        {
            art_and_num[i] = random.nextInt(52);   //한 종류 13개씩 4개 52
            while(true)
            {
                for(int j=0;j<i;j++)
                {   
                    if(art_and_num[i]==art_and_num[j])
                    {
                        check = true;
                    }
                }
                if(check==false)
                {
                    break;
                }else{
                    art_and_num[i] = random.nextInt(52);
                    check = false;
                }
            }
            if(winnerCount < art_and_num[i])
            {
                winner = i;
                winnerCount = art_and_num[i];
            }
            System.out.print((i+1)+"번째 사람의 카드 = ");
            int imsi_art = art_and_num[i]%4;
            int imsi_num = art_and_num[i]/4 + 1;
            
            for (art Art : art.values())
            {
                if(Art.ordinal()==imsi_art)
                {
                    printArt= Art.name();
                }
            }
            System.out.print(printArt);
            if(imsi_num<9)
            {
                System.out.println(imsi_num);
            }else{
                for (char_num Num : char_num.values())
                {
                    if(Num.ordinal()==(imsi_num-9))
                    {
                       printNum= Num.name();
                    }
                }
                System.out.println(printNum);
            }
        }
        System.out.println("Winner is " + (winner+1));
        Scanner.close();
    }
}
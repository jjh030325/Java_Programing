import java.util.Scanner;

public class App {
    public static boolean fail_check(int a, int b, int c, int d)
    {
        if(a<=40 || b<=40 || c<=40 || d<=40)
        {
            return true;
        }else{
            return false;
        }
    }
    public static int average(int a, int b, int c, int d)
    {
        return (a+b+c+d)/4;
    }
    public static void fail()
    {
        System.out.println("fail");
    }
    public static void pass()
    {
        System.out.println("pass");
    }
    public static void score_print(int num, int a, int b, int c, int d)
    {
        if(num%2 == 1)
        {
            System.out.println("(가) 형");
            System.out.println("한국어 점수 : " + a);
            System.out.println("컴퓨터구조 점수 : " + b);
            System.out.println("데이터베이스 점수 : "+ c);
            System.out.println("소프트웨어공학 점수 : " + d);
        }else{
            System.out.println("(나) 형");
            System.out.println("한국어 점수 : " + a);
            System.out.println("영어 점수 : " + b);
            System.out.println("세법 점수 : "+ c);
            System.out.println("국제법 점수 : " + d);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner testnumScanner = new Scanner(System.in);
        String name = testnumScanner.next();
        int num = testnumScanner.nextInt();
        int test1_score = testnumScanner.nextInt();
        int test2_score = testnumScanner.nextInt();
        int test3_score = testnumScanner.nextInt();
        int test4_score = testnumScanner.nextInt();

        System.out.print(name + " ");
        score_print(num, test1_score, test2_score, test3_score, test4_score);

        if(fail_check(test1_score, test2_score, test3_score, test4_score))
        {
            fail();
        }else if(average(test1_score, test2_score, test3_score, test4_score)>=80)
        {
            pass();
        }else
        {
            fail();
        }

        testnumScanner.close();
    }
}
/*
A라는 학생이 자격증 시험을 진행하였다.
A의 응시번호 끝자리가 홀수면 (가)형, 짝수이면 (나)형 시험을 응시하였다.

(가)형은 한국어, 컴퓨터구조, 데이터베이스, 소프트웨어공학 총 4과목 이다.
(나)형은 한국어, 영어, 세법, 국제법 총 4과목이다.

아래 조건을 만족하는 프로그램을 작성하시오.

0. 학생은 자신의 이름, 응시번호 6자리, 시험성적을 입력한다.
1. 평균 80점 이상이면 pass,  80 미만이면 fail이다.
2. 단, 한과목이라도 40점 이하이면 fail이다.
3. 위의 내용을 정리하여 화면에 출력하시오.
 */
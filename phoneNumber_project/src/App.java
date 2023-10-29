import java.util.ArrayList;
import java.util.Scanner;

class PhoneManager
{
    private ArrayList<Phone> list = new ArrayList<>();

    public void input(String name, String phoneNumber)
    {
        list.add(new Phone(name, phoneNumber));
    }
    public void input(String name, String phoneNumber, String mager, String grade)
    {
        list.add(new PhoneUniv(name, phoneNumber, mager, grade));
    }
    public void input(String name, String phoneNumber, String companyName)
    {
        list.add(new PhoneComp(name, phoneNumber, companyName));
    }
    public void search(String name)
    {
        for(int i=0;i<list.size();i++)
        {
            if(name.equals(list.get(i).returnName()))
            {
                list.get(i).display();
                System.out.println("======================================");
                return;
            }
        }
        System.out.println("존재하지 않습니다.");
        return;
    }
    public void delete(String name)
    {
        for(int i=0;i<list.size();i++)
        {
            if(name.equals(list.get(i).returnName()))
            {
                list.remove(i);
                System.out.println("삭제되었습니다.");
                return;
            }
        }
        System.out.println("존재하지 않습니다.");
    }
    public void printAll()
    {
        for(int i=0;i<list.size();i++)
        {
            list.get(i).display();
            System.out.println("======================================");
        }
    }
}

class Phone
{
    //1. 일반(Phone) – 이름, 전화번호
    String Name;
    String PhoneNumber;
    Phone(String name, String phoneNumber)
    {
        this.Name = name;
        this.PhoneNumber = phoneNumber;
    }
    public void display()
    {
        System.out.println("이름 : " + Name);
        System.out.println("전화번호 : " + PhoneNumber);
    }
    public String returnName()
    {
        return Name;
    }
}

class PhoneUniv extends Phone
{
    //2. 대학(PhoneUniv) – 이름, 전화번호, 전공, 학년
    String Mager;
    String Grade;
    PhoneUniv(String name, String phoneNumber, String mager, String grade)
    {
        super(name, phoneNumber);
        this.Mager = mager;
        this.Grade = grade;
    }
    public void display()
    {
        super.display();
        System.out.println("전공 : " + Mager);
        System.out.println("학년 : " + Grade);
    }
}

class PhoneComp extends Phone
{
    //3. 회사(PhoneComp) - 이름, 전화번호, 회사명
    String CompanyName;
    PhoneComp(String name, String phoneNumber, String companyName)
    {
        super(name, phoneNumber);
        this.CompanyName = companyName;
    }
    public void display()
    {
        super.display();
        System.out.println("회사명 : " + CompanyName);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        PhoneManager phoneManager = new PhoneManager();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 검색");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 전체 데이터 출력");
            System.out.println("5. 프로그램 종료");
            System.out.print("선택: ");
            int choose = scanner.nextInt();
            switch(choose)
            {
            case 1:
                System.out.println("1. 일반(Phone)");
                System.out.println("2. 대학(PhoneUniv)");
                System.out.println("3. 회사(PhoneComp)");
                System.out.print("선택: ");
                int type = scanner.nextInt();
                //종류 선택

                System.out.print("이름: ");
                String name = scanner.next();
                System.out.print("전화번호: ");
                String phoneNumber = scanner.next();
                //필수 입력

                switch(type)
                {
                case 1:
                    phoneManager.input(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("전공: ");
                    String mager = scanner.next();
                    System.out.print("학년: ");
                    String grade = scanner.next();
                    phoneManager.input(name, phoneNumber, mager, grade);
                    break;
                case 3:
                    System.out.print("회사명: ");
                    String company = scanner.next();
                    phoneManager.input(name, phoneNumber, company);
                    break;
                }
                break;
                //데이터 입력
            case 2:
                System.out.print("검색할 이름: ");
                String SearchName = scanner.next();
                phoneManager.search(SearchName);
                break;
                //데이터 검색
            case 3:
                System.out.print("삭제할 이름: ");
                String DelName = scanner.next();
                phoneManager.delete(DelName);
                break;
                //데이터 삭제
            case 4:
                phoneManager.printAll();
                break;
                //전체 데이터 출력
            case 5:
                scanner.close();
                System.exit(0);
                break;
                //프로그램 종료
            }
        }
    }
}

/*
사용자로 입력을 받아 프로그램을 실행하는 프로그램

o 주의사항
1. 전체 사용자를 관리하는 클래스(PhoneManager)의 객체는 1개만 생성되도록 한다.
 */
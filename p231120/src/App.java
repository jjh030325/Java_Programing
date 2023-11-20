import java.util.ArrayList;
import java.util.Scanner;

class Member{
    private String id;
    private String name;
    Member(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public String getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
}

class MemberArray
{
    ArrayList<Member> list = new ArrayList<>();
    public void addMember(String id, String name)
    {
        int idcheck = 0;
        for(int i=0;i<list.size();i++)
        {
            if(id.equals(list.get(i).getid()))
            {
                System.out.println("해당 아이디가 이미 존재합니다.");
                idcheck = 1;
                break;
            }
        }
        if(idcheck == 0)
        {
            list.add(new Member(id, name));
            System.out.println("해당 아이디가 추가되었습니다.");
        }
    }
    public void removeMember(String delid)
    {
        int delcheck = 0;
        
        for(int i=0;i<list.size();i++)
        {
            if(delid.equals(list.get(i).getid()))
            {
                System.out.println("삭제되었습니다.");
                delcheck = 1;
                list.remove(i);
                break;
            }
        }
        if(delcheck == 0)
        {
            System.out.println("해당 id가 존재하지 않습니다.");
        }
    }
    public void showAll()
    {
        for(int i=0;i<list.size();i++)
        {
            System.out.println("id : " + list.get(i).getid() + "  name : " + list.get(i).getname());
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MemberArray memberArray = new MemberArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 : 입력, 2 : 출력, 3 : 삭제, 4 : 종료");
            System.out.print("입력하시오 : ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("id : ");
                    String id = scanner.next();
                    System.out.print("name : ");
                    String name = scanner.next();
                    memberArray.addMember(id, name);
                    break;
                case 2:
                    System.out.println("모든 사용자 출력");
                    memberArray.showAll();
                    break;
                case 3:
                    System.out.print("삭제할 아이디 입력 : ");
                    String delid = scanner.next();
                    memberArray.removeMember(delid);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }   
    }
}

/*
1. Member 클래스 (id와 이름, 객체 출력)
2. ArrayList를 활용하여 Member를 관리(입력, 출력, 조회...)
3. 동일한 id를 가진 멤버가 등록되지 않도록 하시오. (addMember)
4. 삭제할 때(removeMember)에는 멤버의 id를 입력받아 삭제하시오.
5. 모든 등록된 사용자를 출력하시오. (showAll)
 */
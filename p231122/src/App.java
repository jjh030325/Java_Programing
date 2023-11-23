import java.util.HashSet;
import java.util.Iterator;

class Member
{
    int num;
    String name;
    Member(int num, String name)
    {
        this.num = num;
        this.name = name;
    }
    public String toString()
    {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        Member p = (Member)obj;
        if(num == p.num)
            return true;
        else return false;
    }

    public int hashCode() {
        return num;
    }
}
class memberHashSet
{
    HashSet<Member> set=new HashSet<Member>();
    public void addMember(Member member)
    {
        set.add(member);
    }
    public void showAll()
    {
        Iterator<Member> itr = set.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
    public void delMember(Member member)
    {
        Iterator<Member> it = set.iterator();
		while(it.hasNext()) {
			Member s = it.next();
			if(s.equals(member)) it.remove();
		}
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        memberHashSet memberHashSet = new memberHashSet();
        
        System.out.println("Generating Member...");
        Member memberLee = new Member(101, "Lee");
        Member memberKim = new Member(102, "Kim");
        Member memberPark = new Member(103, "Park");

        System.out.println("Adding Members...");
        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberKim);
        memberHashSet.addMember(memberPark);
        
        System.out.println("Showing Members...");
        memberHashSet.showAll();

        System.out.println("Adding Members...");
        Member memberLee2 = new Member(101, "Lee2");
        memberHashSet.addMember(memberLee2);

        System.out.println("Showing Members...");
        memberHashSet.showAll();

        System.out.println("Delete Member");
        memberHashSet.delMember(memberLee2);

        System.out.println("Showing Members...");
        memberHashSet.showAll();
    }
}

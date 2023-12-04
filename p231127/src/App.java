import java.util.Set;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Comparator;

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

class AgeComparator implements Comparator<Integer> {
    public int compare(Integer n1, Integer n2) {
        return n2.intValue() - n1.intValue();
    }
}

class MemberTreeMapSet
{
    TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());

    public void insert(int id, String name)
    {
        if(!map.containsKey(id))
        {
            map.put(id, name);
        }
    }
    public void delete(int id)
    {
        map.remove(id);
    }
    public void search(int id)
    {
        if(map.get(id) != null)
        {
            System.out.println(id + " = " + map.get(id));
        }else{
            System.out.println(id + "는 존재하지 않습니다.");
        }
        
    }
    public void print()
    {
        Set<Integer> ks = map.keySet();
        // 전체 Key 출력 (for-each문 기반)
        for(Integer n : ks)
            System.out.print(n.toString() + '\t');
        System.out.println();
        // 전체 Value 출력 (반복자 기반)
        for(Iterator<Integer> itr = ks.iterator(); itr.hasNext(); )
            System.out.print(map.get(itr.next()) + '\t');
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MemberTreeMapSet memberTreeSet = new MemberTreeMapSet();
        
        memberTreeSet.insert(1, "조준현");
        memberTreeSet.insert(2, "홍길동");
        memberTreeSet.insert(3, "가나다");
        memberTreeSet.insert(3, "이미 있지롱");

        memberTreeSet.print();

        memberTreeSet.search(1);
        memberTreeSet.delete(1);
        memberTreeSet.search(1);

        memberTreeSet.print();
    }
}

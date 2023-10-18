class Car{
    Tire leftfront = new Tire(6, "왼쪽 앞");
    Tire rightfront = new Tire(2, "오른쪽 앞");
    Tire leftback = new Tire(3, "왼쪽 뒤");
    Tire rightback = new Tire(4, "오른쪽 뒤");
    Car(){}
    public void display()
    {
        leftfront.display("왼쪽 앞 ");
        rightfront.display("오른쪽 앞 ");
        leftback.display("왼쪽 뒤 ");
        rightback.display("오른쪽 뒤 ");
    }
    public void run()
    {
        leftfront.roll();
        rightfront.roll();
        leftback.roll();
        rightback.roll();
        if(leftfront.returnlife()==0 || rightfront.returnlife()==0 || leftback.returnlife()==0 || rightback.returnlife()==0)
        {
            System.out.println("차 정지");
        }
        if(leftfront.returnlife()==0)
        {
            System.out.println("왼쪽 앞바퀴 펑크");
            leftfront = change(leftfront);
        }
        if(rightfront.returnlife()==0)
        {
            System.out.println("오른쪽 앞바퀴 펑크");
            rightfront = change(rightfront);
        }
        if(leftback.returnlife()==0)
        {
            System.out.println("왼쪽 뒷바퀴 펑크");
            leftback = change(leftback);
        }
        if(rightback.returnlife()==0)
        {
            System.out.println("오른쪽 뒷바퀴 펑크");
            rightback = change(rightback);
        }
    }
    public HankookTire change(Tire tire)
    {
        System.out.print(tire.returnWhere());
        System.out.println("Tire를 HankookTire로 교체");
        return new HankookTire(5, tire.returnWhere());
    }
    public gumoTire change(HankookTire hankookTire)
    {
        System.out.print(hankookTire.returnWhere());
        System.out.println("HankookTire를 gumoTire로 교체");
        return new gumoTire(10, hankookTire.returnWhere());
    }
    public gumoTire change(gumoTire gumoTire)
    {
        System.out.print(gumoTire.returnWhere());
        System.out.println("gumoTire를 gumoTire로 교체");
        return new gumoTire(10, gumoTire.returnWhere());
    }
}
class Tire{
    String where;
    String name;
    int life;
    Tire(int life, String where)
    {
        this.where = where;
        this.name = "Tire";
        this.life = life;
    }
    public void roll()
    {
        life -= 1;
    }
    public int returnlife()
    {
        return life;
    }
    public void display(String what)
    {
        System.out.println(what + "위치 " + name + "의 내구도 : " + life);
    }
    public String returnWhere()
    {
        return where;
    }
}
class HankookTire extends Tire{
    HankookTire(int life, String where)
    {
        super(life, where);
        this.name = "HankookTire";
    }
}
class gumoTire extends Tire{
    gumoTire(int life, String where)
    {
        super(life, where);
        this.name = "gumoTire";
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        for(int i=1;i<=10;i++)
        {
            System.out.println(i + "회 운전");
            car.run();
            car.display();
            System.out.println("==========================================");
        }
    }
}

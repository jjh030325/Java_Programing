class Apple{
    private String name;
    Apple()
    {
        name = "사과";
    }
    public void printname()
    {
        System.out.println(name);
    }
}
class Orange{
    private String name;
    Orange()
    {
        name = "오렌지";
    }
    public void printname()
    {
        System.out.println(name);
    }
}
class Plastic{
    private String name;
    Plastic()
    {
        name = "플라스틱";
    }
    public void printname()
    {
        System.out.println(name);
    }
}

class PrinrterGeneric<T>{
    private T t;
    public T get() { return t;}
    public void set(T t) { this.t = t;}
}

public class App {
    public static <T> void PrintArray(T[] arr)
    {
        for(int i=0;i<arr.length - 1;i++)
        {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }
    public static void main(String[] args) throws Exception {
        //1번
        Apple A = new Apple();
        Orange O = new Orange();
        Plastic P = new Plastic();
        PrinrterGeneric<Apple> apple = new PrinrterGeneric<Apple>();
        PrinrterGeneric<Orange> orange = new PrinrterGeneric<Orange>();
        PrinrterGeneric<Plastic> plastic = new PrinrterGeneric<Plastic>();

        apple.set(A);
        orange.set(O);
        plastic.set(P);

        apple.get().printname();
        orange.get().printname();
        plastic.get().printname();

        //2번
        Integer[] a = {1,2,3,4,5};
        Character[] b = {'a','b','c','d','e'};
        
        PrintArray(a);
        PrintArray(b);
    }
}
/*
1. (제네릭 클래스) 모든 형태의 재료를 출력할 수 있는 PrinrterGeneric 클래스를 만드시오.
예) Apple 클래스의 "사과" , Orange 클래스의 "오렌지", Plastic 클래스의 "플라스틱",...

2. (제네릭 메소드) 모든 형태의 배열값(integer값이 담긴 배열, character값이 담긴 배열, 등등)을 출력할 수 있는 PrintArray 제네릭 메소드를 만드시오.
예) 1,2,3,4,5, a,b,c,d,e,......
 */
class Box<T>{
    private T ob;
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

public class App {
    public static <T> void swapBox(Box<T> b1, Box<T> b2)
    {
        Box<T> tmpBox = new Box<T>();
        tmpBox.set(b1.get());
        b1.set(b2.get());
        b2.set(tmpBox.get());
    }
    public static <T extends Number>void swapBox2(Box<T> b1, Box<T> b2) //숫자만 가능한 것
    {
        Box<T> tmpBox = new Box<T>();
        tmpBox.set(b1.get());
        b1.set(b2.get());
        b2.set(tmpBox.get());
    }
    public static void main(String[] args) throws Exception {
        Box<Integer> box1 = new Box<Integer>();
        box1.set(24);
        Box<Integer> box2 = new Box<Integer>();
        box2.set(37);
        Box<String> box3 = new Box<String>();
        box3.set("AAA");
        Box<String> box4 = new Box<String>();
        box4.set("BBB");
        Box<Character> box5 = new Box<Character>();
        box5.set('a');
        Box<Character> box6 = new Box<Character>();
        box6.set('b');

        swapBox(box1, box2);
        swapBox(box3, box4);
        swapBox(box5, box6);
        System.out.println(box1.get() + " " + box2.get());
        System.out.println(box3.get() + " " + box4.get());
        System.out.println(box5.get() + " " + box6.get());
        swapBox2(box1, box2);
        System.out.println(box1.get() + " " + box2.get());
    }
}

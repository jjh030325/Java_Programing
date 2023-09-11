public class App {
    public static double SubToHwa(double sub)
    {
        return (sub * 9/5) + 32;
    }
    public static void main(String[] args) throws Exception {
        final double MILETOKILO = 1.609;                 //마일을 킬로미터로 변환하는 상수
        double mile = 10.0;
        double kilo = mile * MILETOKILO;
        System.out.println(mile + "마일은 " + kilo + "킬로미터입니다.");
        mile = 20.0;
        kilo = mile * MILETOKILO;
        System.out.println(mile + "마일은 " + kilo + "킬로미터입니다.");
        mile = 30.0;
        kilo = mile * MILETOKILO;
        System.out.println(mile + "마일은 " + kilo + "킬로미터입니다.");
        mile = 40.0;
        kilo = mile * MILETOKILO;
        System.out.println(mile + "마일은 " + kilo + "킬로미터입니다.");
        mile = 50.0;
        kilo = mile * MILETOKILO;
        System.out.println(mile + "마일은 " + kilo + "킬로미터입니다.");

        double sub = 36.0;
        double hwa = SubToHwa(sub);
        System.out.println("섭씨 " + sub +"도는 화씨 " + hwa + "입니다.");
        sub = 0.0;
        hwa = SubToHwa(sub);
        System.out.println("섭씨 " + sub +"도는 화씨 " + hwa + "입니다.");
        sub = 5.0;
        hwa = SubToHwa(sub);
        System.out.println("섭씨 " + sub +"도는 화씨 " + hwa + "입니다.");
        sub = 20.0;
        hwa = SubToHwa(sub);
        System.out.println("섭씨 " + sub +"도는 화씨 " + hwa + "입니다.");
        sub = 30.0;
        hwa = SubToHwa(sub);
        System.out.println("섭씨 " + sub +"도는 화씨 " + hwa + "입니다.");
    }
}

class Car {
    public int gasolineGauge;

    public Car(int gasolineGauge)
    {
        this.gasolineGauge = gasolineGauge;
    }
    public void showCurrentGauge()
    {
        System.out.println("잔여 가솔린:"+gasolineGauge);
    }
}

class HybridCar extends Car {  
    public double electricGauge;

    public HybridCar(int gasolineGauge, double electricGauge)
    {
        super(gasolineGauge);
        this.electricGauge = electricGauge;
    }
    public void showCurrentGauge()
    {
        System.out.println("잔여 가솔린:"+gasolineGauge);
        System.out.println("잔여 전기량:"+electricGauge);
    }
}

class HybridWaterCar extends HybridCar {   
    public int waterGauge;
    public HybridWaterCar(double electricGauge, int waterGauge)
    {
        super(0, electricGauge);
        this.waterGauge = waterGauge;
    }
    public HybridWaterCar(int gasolineGauge, double electricGauge, int waterGauge)
    {
        super(gasolineGauge, electricGauge);
        this.waterGauge = waterGauge;
    }
    public void showCurrentGauge()
    {
        System.out.println("잔여 가솔린:"+gasolineGauge);
        System.out.println("잔여 전기량:"+electricGauge);
        System.out.println("잔여 워터량:"+waterGauge);
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        HybridWaterCar hwCar1 = new HybridWaterCar(4.2, 2);
        hwCar1.showCurrentGauge();
        HybridWaterCar hwCar2 = new HybridWaterCar(9, 5.1, 7);
        hwCar2.showCurrentGauge();
        HybridCar hwCar3 = new HybridCar(5, 5.1);
        hwCar3.showCurrentGauge();
        Car hwCar4 = new Car(10);
        hwCar4.showCurrentGauge();
    }
}

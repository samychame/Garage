public class Car extends Vehicle{

    private static int CAR_FIXTIME = 5;

    public Car(String name){
        super(CAR_FIXTIME, name);
    }

    @Override
    public void fixed() {
        System.out.println(super.name + " car fixed!");
    }

    @Override
    public int getFixTime() {
        return CAR_FIXTIME;
    }

    @Override
    public String toString() {
        return "Car "+ super.name + "[Fix time: " + CAR_FIXTIME + "h]";
    }
}

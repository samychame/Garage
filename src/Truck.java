public class Truck extends Vehicle{

    private static int TRUCK_FIXTIME = 10;
    public Truck(String name){
        super(TRUCK_FIXTIME, name);
    }

    @Override
    public void fixed() {
        System.out.println(super.name + " truck fixed!");
    }

    @Override
    public int getFixTime() {
        return TRUCK_FIXTIME;
    }

    @Override
    public String toString() {
        return "Truck "+ super.name + "[Fix time: " + TRUCK_FIXTIME + "h]";

    }
}

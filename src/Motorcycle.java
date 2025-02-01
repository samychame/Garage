public class Motorcycle extends Vehicle{

    private static int MOTORCYCLE_FIXTIME = 3;
    public Motorcycle(String name){
        super(MOTORCYCLE_FIXTIME,name);
    }

    public static Motorcycle build(String name){
        return new Motorcycle(name);
    }

    @Override
    public void fixed() {
        System.out.println(super.name + " motorcycle fixed!");
    }

    @Override
    public int getFixTime() {
        return MOTORCYCLE_FIXTIME;
    }

    @Override
    public String toString() {
        return "Motorcycle "+ super.name + "[Fix time: " + MOTORCYCLE_FIXTIME + "h]";

    }
}

import java.util.ArrayList;

public class DB {

    public static ArrayList<Vehicle> vehicles = new ArrayList<>();


    public static void addVehicle(Vehicle vehicle){
        if(vehicle == null){
            return;
        }
        vehicles.add(vehicle);
        System.out.println("Vehicle added");
    }

    public static ArrayList<Vehicle> getVehicles(){
        return  vehicles;
    }
}

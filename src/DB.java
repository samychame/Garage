import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DB {

    public static HashMap<Integer, PriorityQueue<Vehicle>> vehicles = new HashMap<>();

    public static void build(int type, String model){
        if(model == null || model.isEmpty()){
            System.out.println("Model not valid");
            return;
        }
        if(type == 1){//Motorcycle
            addVehicle(new Motorcycle(model),1);
        } else if (type == 2) {//Car
            addVehicle(new Car(model),2);
        }else{//Truck (3)
            addVehicle(new Truck(model),3);

        }

    }

    private static void addVehicle(Vehicle vehicle,int type){
        if(vehicles.isEmpty()){
            startMap();
        }
        if(vehicle == null) {
            return;
        }
        vehicles.get(type).add(vehicle);
        System.out.println("Vehicle added");
    }

    public static void startMap(){
        vehicles.put(1,new PriorityQueue<>());
        vehicles.put(2,new PriorityQueue<>());
        vehicles.put(3,new PriorityQueue<>());
    }


    public static ArrayList<Vehicle> getVehicleList() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        if(vehicles.isEmpty()){
            return vehicleList;
        }
        for(PriorityQueue<Vehicle> queue : vehicles.values()){
            vehicleList.addAll(queue);
        }
        return vehicleList;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {

    private int hour_counter = 0;
    private ProtocolGarage protocolGarage;
    private ScheduledExecutorService executor; // Instance-level executor

    public Garage(ProtocolGarage protocolGarage) {
        this.protocolGarage = protocolGarage;
    }

    public void start() {
        ArrayList<Vehicle> vehicles = DB.getVehicleList();
        Runnable task = () -> tick(vehicles);

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }

    private void tick(ArrayList<Vehicle> vehicles) {
        if (!vehicles.isEmpty()) {
            if(hour_counter == 0){
                protocolGarage.startFixing(vehicles.get(0));
            }
            hour_counter++;
            System.out.println(hour_counter + " hours passed");
            // Check if the fix time for the first vehicle in the list has passed
            if (vehicles.get(0).getFixTime() == hour_counter) {
                fixVehicle(vehicles);
            }
        }

        // Check if all vehicles are fixed and shut down the executor
        if (vehicles.isEmpty()) {
            executor.shutdown(); // Initiate orderly shutdown
            protocolGarage.finished();
        }
    }


    private void fixVehicle(ArrayList<Vehicle> vehicles) {
        // Remove the vehicle from the list and reset the counter
        Vehicle v = vehicles.remove(0);
        hour_counter = 0;

        // Call the protocol's fixed method to update the UI
        protocolGarage.fixed(v);
    }

}

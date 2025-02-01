import java.util.Scanner;

public class MainScreen {

    public static void start(){
        populateVehicles();
        Garage garage = new Garage(protocolGarage);
        garage.start();

    }

    private static ProtocolGarage protocolGarage = new ProtocolGarage() {
        @Override
        public void fixed(Vehicle vehicle) {
            vehicle.fixed();
        }

        @Override
        public void finished() {
            System.out.println("\nAll vehicles are fixed. Garage is stopping.");
        }

        @Override
        public void startFixing(Vehicle v) {
            System.out.println("Started fixing "+ v);
        }
    };

    public static void populateVehicles() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
            What type of vehicle would you like to get fixed?
            -1 -> Exit
            1 -> Motorcycle
            2 -> Car
            3 -> Truck
            [INPUT]: """);
            int type = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer

            if (type == -1 ) { // Exit condition
                break;
            }
            if( type < 1 || type > 3 ) { // Invalid option
                System.out.println("Invalid option");
                continue;
            }

            System.out.println("Enter the name of the vehicle: ");
            String name = scanner.nextLine();

            DB.build(type,name);
        }
    }

    public static void main(String[] args){
        start();
    }


}

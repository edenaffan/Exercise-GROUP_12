
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

/**
 * Write a description of class Vehicle here.
 *
 * @author (Affan Abubakar Hassan)
 * @version (a version number or a date)
 */
 class Vehicle{
    protected String brand;
    protected String model;
    protected int year;
    protected double price;

public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
    }

    public void startEngine() {
        System.out.println(brand + " " + model + " engine started");
    }

    public void stopEngine() {
        System.out.println(brand + " " + model + " engine stopped");
    }
} 

class Car extends Vehicle {
    private int numDoors;
    private String fuelType;
    
public Car(String brand, String model, int year, double price,int numDoors, String fuelType){
    super(brand, model, year, price);
    
    this.numDoors=numDoors;
    this.fuelType=fuelType;
    
    }
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Number of doors: " + numDoors);
        System.out.println("Fuel type: " + fuelType);
    }
    public void honk() {
    System.out.println(brand + " " + model + " says: Beep! Beep!");
}


public void openTrunk() {
    System.out.println("Opening trunk of " + brand + " " + model);
    }
}

class Motorcycle extends Vehicle {

    // Motorcycle-specific attributes
    private int engineCC;
    private boolean hasHelmetStorage;

    // Constructor
    public Motorcycle(String brand, String model, int year, double price,
                      int engineCC, boolean hasHelmetStorage) {

        // Call parent constructor
        super(brand, model, year, price);

        // Initialize Motorcycle attributes
        this.engineCC = engineCC;
        this.hasHelmetStorage = hasHelmetStorage;
    }

    // Override displayInfo()
    @Override
    public void displayInfo() {
        // Show parent info first
        super.displayInfo();

        // Add motorcycle info
        System.out.println("Engine CC: " + engineCC);
        System.out.println("Has helmet storage: " + hasHelmetStorage);
    }

    // Motorcycle-specific method: wheelie
    public void wheelie() {
        System.out.println(brand + " " + model + " is doing a wheelie!");
    }

    // Motorcycle-specific method: kickStart
    public void kickStart() {
        System.out.println("Kick starting " + brand + " " + model);
    }
}

class ElectricCar extends Car {

    // ElectricCar-specific attributes
    private double batteryCapacity; // in kWh
    private int range; // in km

    // Constructor
    public ElectricCar(String brand, String model, int year, double price,
                       int numDoors, String fuelType,
                       double batteryCapacity, int range) {

        // call Car constructor first
        super(brand, model, year, price, numDoors, fuelType);

        // initialize ElectricCar attributes
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    // Override startEngine()
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + " electric motor activated silently");
    }

    // Method to charge battery
    public void charge() {
        System.out.println("Charging " + brand + " " + model + "... Battery: " + batteryCapacity + " kWh");
    }

    // Method to display battery status
    public void displayBatteryStatus() {
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range: " + range + " km");
    }
}


public class TestVehicles {
    public static void main(String[] args) {

        // -------- Vehicle --------
        Vehicle v = new Vehicle("GenericBrand", "ModelX", 2020, 1000000);
        System.out.println("--- Vehicle ---");
        v.displayInfo();
        v.startEngine();
        v.stopEngine();

        System.out.println();

        // -------- Car --------
        Car c = new Car("Toyota", "Corolla", 2022, 15000000, 4, "Petrol");
        System.out.println("--- Car ---");
        c.displayInfo();   // overridden
        c.startEngine();   // inherited
        c.honk();          // car-specific
        c.openTrunk();     // car-specific
        c.stopEngine();    // inherited

        System.out.println();

        // -------- Motorcycle --------
        Motorcycle m = new Motorcycle("Yamaha", "R15", 2023, 12000000, 155, true);
        System.out.println("--- Motorcycle ---");
        m.displayInfo();   // overridden
        m.startEngine();   // inherited
        m.wheelie();       // motorcycle-specific
        m.kickStart();     // motorcycle-specific
        m.stopEngine();    // inherited

        System.out.println();

        // -------- ElectricCar --------
        ElectricCar ec = new ElectricCar("Tesla", "Model 3", 2023, 50000000, 4, "Electric", 75.0, 500);
        System.out.println("--- ElectricCar ---");
        ec.displayInfo();           // overridden
        ec.startEngine();           // overridden
        ec.charge();                // electric-car specific
        ec.displayBatteryStatus();  // electric-car specific
        ec.honk();                  // inherited from Car
        ec.openTrunk();             // inherited from Car
        ec.stopEngine();            // inherited from Vehicle
    }
}









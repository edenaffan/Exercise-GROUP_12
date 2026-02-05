
/**
 * Write a description of class vehicle here.
 *
 * @author (24BIA040)
 * @version (a version number or a date)
 */
class Vehicle
{
    
protected String brand;
protected String model;
protected int year;
protected double price;
public Vehicle (String brand ,String model, int year,double price){
    this.brand  = brand ;
    this.model = model;
    this.year = year;
    this.price =price;
    System.out.println("Vehicle constructor called");
}
public  void  displayInfo(){
    System.out.println("Brand of vehicle:"+brand);
    System.out.println("Model of vehicle:"+model);
    System.out.println("Year of vehicle:"+year);
    System.out.println("Price of vehicle:"+price);
}
public void startEngine(){
    System.out.println(brand+" "+model+"engine started");
    
}
public void StopEngine(){
    System.out.println(brand+" "+model+"engine stopped");
}
}
class Car extends Vehicle{
    private int numDoors;
    private String fuelType;
    public Car(String brand, String model,int year,double price, int numDoors,String fuelType){
        super(brand,model,year,price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
        System.out.println("Car constructor called");
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Doors:"+numDoors);
        System.out.println("Fuel Type:" +fuelType);
    }
    public void honk()
    {
        System.out.println(brand+" " +model+ " says: Beep! Beep!");
    }
    public void openTrunk(){
        System.out.println("Opening trunk of :"+brand+ ""+model);
        
    }
    
}
class motorcycle extends Vehicle{
    private int engineCC;
    private boolean hasHelmetStorage;
    public motorcycle(String brand,String model,int year,double price,int engineCC,boolean hasHelmetStorage){
        super(brand,model,year,price);
        this.engineCC = engineCC;
        this.hasHelmetStorage= hasHelmetStorage;
        System.out.println("Motocycle Constructor called");
        
        
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Engine:" +engineCC+"cc");
        System.out.println("Helmet Storage:" +(hasHelmetStorage? "yes": "No"));
    }
    public void wheelie()
    {
        System.out.println(brand+ " " +model+ " is doing a wheelie!");
        
    }
    public void kickStart()
    {
        System.out.println("Kick starting" + brand +" " +model);
        
    }
    
}
class ElectricCar extends Car{
    private double batteryCapacity;
    private int range;
    public ElectricCar(String brand ,String model, int year,double price, int numDoors,String fuelType,double batteryCapacity,int range){
        
        super(brand,model,year,price,numDoors,fuelType);
        this.batteryCapacity =batteryCapacity;
        this.range =range;
        System.out.println("ElectricCar constructor called");
    }
    @Override
    public void startEngine(){
        System.out.println(brand+ " " +model+ "electric motor activated silently");
    }
    public void charge(){
        System.out.println("Charging "+ brand+ " "+model+"... battery:" +batteryCapacity+"km");
        
        
    }
    public  void displayBatteryStatus(){
        System.out.print("battery capacity:"+batteryCapacity+"km");
        System.out.println("range:" +range+"km");
    }
}   
public class exercise12_inheritance{
        public static void main(String[] args){
            System.out.println("=== VEHICLE HIERACHY TEST===\n");
            Car car = new Car("toyota", "corolla",2023,45000000,4,"petrol");
            motorcycle motorcycle = new motorcycle("honda","CBR500R",2022,15000000,500,false);
            ElectricCar electricCar = new ElectricCar("tesla","model3",2024,85000000,4,"electric",75.0,450);
            
            System.out.println("--- testing car---");
            car.displayInfo();
            car.startEngine();
            car.honk();
            car.openTrunk();
            car.startEngine();
            
            System.out.println("\n--- testing motorcycle---");
            motorcycle.displayInfo();
            motorcycle.startEngine();
            motorcycle.wheelie();
            motorcycle.kickStart();
            motorcycle.startEngine();
            
            System.out.println("\n--- testing electric Car---");
            electricCar.displayInfo();
            electricCar.startEngine();
            electricCar.charge();
            electricCar.displayBatteryStatus();
            electricCar.honk();
            electricCar.StopEngine();
            
            System.out.println("\n---polymophism demo---");
            Vehicle[] vehicles= {car,motorcycle,electricCar};
            for (Vehicle v: vehicles){
                v.displayInfo();
                v.startEngine();
                System.out.println();
                
            }
            System.out.println("=== END  OF TEST ===");
        }
    }
    


 

    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        






   
    

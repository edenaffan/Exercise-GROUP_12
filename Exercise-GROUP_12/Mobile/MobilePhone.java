
/**
 * Write a description of class MobilePhone here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MobilePhone{
    private String brand;
    private String model;
    private double price;
    private int batteryLevel;
    private boolean isOn;
    public MobilePhone(){
        brand="Unknown";
        model="Unknown";
        price=0;
        batteryLevel=100;
        isOn=false;}
        public MobilePhone(String brand,String model,double price){
            this.brand=brand;
            this.model=model;
            this.price=price;
        }
        public String getbrand() {return brand; }
        public String getmodel() {return model; }
        public double getprice() {return price; }
        public int getbatteryLevel() {return batteryLevel; }
        public boolean getisOn() {return isOn; }
        public void setbrand(String brand){
            this.brand=brand;
        }
        public void setmodel(String model){
            this.model=model;
        }
        public void setprice(double price) {
            if (price>0) {
                this.price=price;
            }
        }
        public void setbatteryLevel(int batteryLevel) {
            if (batteryLevel >=0 && batteryLevel <=100) {
                this.batteryLevel = batteryLevel;
                }
            else{
                    System.out.println("Battery level must be 0 and 100");
            }
        }
        public void turnOn(){
            if (batteryLevel > 0) {
                isOn=true;
                System.out.println("Phone is on");
            }
            else{
                System.out.println("battery is empty");
            }
        }
        public void turnOff(){
            if (batteryLevel <= 0) {
                isOn=false;
                System.out.println("Phone tuns off");}
                else{
                    System.out.println("Phone is on");
                }
            }
        public void makeCall(String ContactName) {
            if (isOn && batteryLevel >=5){
                System.out.println("Calling " +ContactName);
                this.batteryLevel -=5;
            }
            else{
                System.out.println("Cannot make call, check battery status");
            }
        }
        public void chargeBattery(int minutes) {
            int charge=minutes*2+ batteryLevel;
            if (charge >=100) {
                this.batteryLevel=100;
            }
            else{
                this.batteryLevel=charge;
                
            }
            System.out.println("Battery level is "+batteryLevel);
        }
        public void displayInfo(){
        System.out.println("Brand is" +brand);
        System.out.println("Model is: " +model);
        System.out.println("price: "+ price);
        System.out.println("battery level is: "+ batteryLevel);
        System.out.println("battery is on: " +isOn);
    }
    public static void main(String[] args) {
        System.out.println("=== Mobile phone ===");
        MobilePhone phone1 = new MobilePhone();
        phone1.setbrand("Samsung");
        phone1.setmodel("Galaxy S24");
        phone1.setprice(2500000);
        phone1.turnOn();
        phone1.makeCall("Ali");
        phone1.makeCall("Othman");
        phone1.makeCall("Maryam");
        phone1.displayInfo();
        phone1.chargeBattery(10);
        phone1.displayInfo();
        System.out.println("=== Excersise Compilete===");
        }
}

        
            

    
    
    
    
    
    


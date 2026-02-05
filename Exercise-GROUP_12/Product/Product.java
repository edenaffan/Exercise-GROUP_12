package Product;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product{
    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;
    
    public Product(){
        this.productCode = "001";
        this.productName = "Mango";
        this.category = "Fruits";
        this.unitPrice = 1500.00;
        this.quantityInStock = 5;
        this.reorderLevel = 10;
        
    }
    public Product(String productCode,String productName,String category,double unitPrice,int quantityInStock,int reorderLevel){
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = reorderLevel;
        
    }
    public String getproductCode(){
        return productCode;
    }
    public String getproductName(){
        return productName;
    }
    public String getcategory(){
        return category;
    }
    public double getunitPrice(){
        return unitPrice;
    }
    public int getquantityInStock(){
        return quantityInStock;
    }
    public int getreorderLevel(){
        return reorderLevel;
    }
    
    public void setunitPrice(double unitPrice){
        if(unitPrice > 0){
            this.unitPrice = unitPrice;
        }else{
            System.out.println("Not for sale.");
        }
    }
    public void setquantityInStock(int quantityInStock){
        if(quantityInStock >= 0){
            this.quantityInStock = quantityInStock;
        }else{
            System.out.println("Quantity not available");
        }
    }
    public void setreorderLevel(int reorderLevel){
        if(reorderLevel > 0){
            this.reorderLevel = reorderLevel;
        }else{
            System.out.println("You are late to order another product");
        }
    }
    public void addStock(int quantity){
        if(quantity > 0){
            this.quantityInStock += quantity;
            System.out.println("Added" +quantity+ "units. New stock:" +quantityInStock);
        }else{
            System.out.println("Error: Quantity must me positive");
        }
    }
    public boolean sellProduct(int quantity){
        if(quantity <= 0){
            System.out.println("Error: Quantity must be positive");
            return false;
        }
        
        if (quantity <= quantityInStock){
            quantityInStock -= quantity;
            System.out.println("Sold" +quantity+ "units. Remaining stock " +quantityInStock);
            return true;
        }else{
            System.out.println("Error: No stock in the building." +quantityInStock);
            return false;
        }
    }
    public double calculateStockValue(){
        return unitPrice * quantityInStock;
    }
    
    public boolean needsReorder(){
        return quantityInStock <= reorderLevel;
    }
    
    public void applyDiscount(double percentage){
        if (percentage > 0 && percentage <= 100){
            double discountAmount = unitPrice * (percentage / 100);
            unitPrice -= discountAmount;
            System.out.println("You get Discount of " +percentage+ "% applied. New price: $" + String.format("%.2f", unitPrice));
        }else{
            System.out.println("Error: Discount percentage must be between 0 and 100");
        }
    }
    
    public void displayProductInfo(){
        System.out.println("=== Product Information ===");
        System.out.println("=== Product Code" +productCode);
        System.out.println("=== Product Name " +productName);
        System.out.println("=== Category " +category);
        System.out.println("=== Unit Price: $ " +String.format("%.2f", unitPrice));
        System.out.println("=== Quantity in Stock: " +quantityInStock);
        System.out.println("=== Reoder Level " + reorderLevel);
        System.out.println("=== Stock Value: $" +String.format("%.2f", calculateStockValue()));
        System.out.println("=== Reorder Needed:  ===" +(needsReorder() ? "YES" : "NO"));
        System.out.println("=====================================================");
    }
}
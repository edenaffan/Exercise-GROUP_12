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
        this.reorderLevel = 4;
        
    }
    public Product(String productCode,String productName,String category,double unitPrice,int quantityInStock,int reorderLevel){
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = reorderLevel;
        
        
    }
    
    
}
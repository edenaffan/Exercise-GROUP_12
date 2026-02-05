
/**
 * Write a description of class Exercise_employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exercise_employee
{
    private String  employee_id;
    private String  fullName; 
    private String  department;
    private double  basicSalary;
    private int  yearsofSurvice;
    
    public Exercise_employee(){
        this.employee_id = "mmanga";
        this.fullName = "Massoud Hamad Mmanga";
        this.department = "Computer Science";
        this.basicSalary = 6000000.0;
        this.yearsofSurvice = 15;
    }
    
    public Exercise_employee(String employee_id ,String fullName, String department ,int yearsofSurvice,double basicSalary){
        this.employee_id  = employee_id ;
        this.fullName = fullName;
        this.department = department;
        this.yearsofSurvice = yearsofSurvice;
        this.basicSalary = basicSalary;
        
    }
    public String getEmployee_id(){
        return employee_id;
    }
    public String getfullName(){
        return fullName;
    }  
    public String getdepartment(){
        return  department;
    }
    public double getBasicSalary(){
        return basicSalary;
    }
    public int getyearOfSurvices(){
        return yearsofSurvice;
    }
    public void setBasicSalary(double basicSalary){
        if(basicSalary>=500000){
            this.basicSalary = basicSalary;
        }else{
            System.out.println("Basic salary must be at least 500000.");
    }
}
        
 public void setyearOfSurvices(int yearOfSurvices){
        if(yearsofSurvice>=0){
            this.yearsofSurvice =yearsofSurvice;
        }else{
            System.out.println("Years of services cannot be negative.");
        }
        }
    
    public  double  calculateBonus(){
        double bonusPercentage = yearsofSurvice* 10;
        
    if(bonusPercentage >50){
        bonusPercentage =50;
        }

  return basicSalary* bonusPercentage/100; 
}
  public double calculateNetSalary(){
      double bonus  =calculateBonus();
      double grossSalary = basicSalary+bonus;
      double tax =grossSalary*0.15;
      return grossSalary-tax;
    }
  
public void promote(String newDepartment,double salaryIncrese){
    this.department =newDepartment;
    if (salaryIncrese > 0){
        this.basicSalary+= salaryIncrese;
        
        
    }
System.out.println(fullName+"has been promoted to"+ newDepartment);
}
public void displayPayslips() {
    System.out.println("------ PAYSLIP------");
    System.out.println("Employee_Id:"+ employee_id);
    System.out.println("Name:" + fullName);
    System.out.println("Department:" + department);
    System.out.println("Years of Services:"  + yearsofSurvice);
    System.out.println("Basic Salary:"  + basicSalary);
    System.out.println("bonus:" + calculateBonus());
    System.out.println("Net Salary:" +calculateNetSalary());
    System.out.println("---------------\n");

    
}

public static void  main(String[] args){
    System.out.println("=== Employee Payroll Exercise ===\n");
    Exercise_employee employee1 = new Exercise_employee("EMP001","ALI HASSAN","IT",1500000);
    Exercise_employee employee2 =new Exercise2_employee("EMP002","FATMA SAID","HR",1200000);
    employee1.setyearOfSurvices(5);
    employee2.setyearOfSurvices(2);
    employee1.displaypayslips();
    employee2.displaypayslips();
    employee1.promote("Senior IT",300000);
    employee1.displaypayslips();
    System.out.println("===Exercise complete ===");
  }
  
  
}
    
        
    
    
          
          

  
    

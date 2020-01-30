package employee;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;
    
    public CommissionEmployee(String firstName, String lastName,
            String socialSecurityNumber, double grossSales, 
            double commissionRate){
        
        super(firstName, lastName, socialSecurityNumber);
        
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
        
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;  
    }
    
    public void setGrossSales(double grossSales){
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
            "Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }
    
    public double getGrossSales(){
        return grossSales;
    }
    
    public void setCommissionRate(double commissionRate){
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
        this.commissionRate = commissionRate;
    }
    
    public double getCommissionRate(){
        return commissionRate;
    }
    
    public double earnings(){
        return getCommissionRate() * getGrossSales();
    }
    
    public String startString(){
        return String.format("%s%s    %s: %.2f%n    %s: %.2f%n    ",
                "Commissioned Employee", super.toString(),
                "Gross Sales", getGrossSales(),
                "Commission Rate", getCommissionRate());
    }
    
    @Override
    public String toString(){
        return String.format("%s%s: $%.2f%n",
                startString(),
                "Earnings", earnings());
    }
    
}

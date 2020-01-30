package employee;

public class HourlyEmployee extends Employee{
    private double hourlyWage;
    private double hoursWorked;
    
    public HourlyEmployee(String firstName, String lastName,
            String socialSecurityNumber, double hourlyWage,
            double hoursWorked){
        
        super(firstName, lastName, socialSecurityNumber);
        
        if (hourlyWage <= 0.0)
            throw new IllegalArgumentException(
            "Hourly wage must be > 0.0");
        
        if (hoursWorked < 1.0 || hoursWorked > 168.0)
            throw new IllegalArgumentException(
            "Hours worked must be >= 1.0 and <= 168.0");
        
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }
    
    public void setHourlyWage(double hourlyWage){
        if (hourlyWage <= 0.0)
            throw new IllegalArgumentException(
            "Hourly wage must be > 0.0");
        
        this.hourlyWage = hourlyWage;
    }
    
    public double getHourlyWage(){
        return hourlyWage;
    }
    
    public void setHoursWorked(double hoursWorked){
        if (hoursWorked < 1.0 || hoursWorked > 168.0)
            throw new IllegalArgumentException(
            "Hours worked must be >= 1.0 and <= 168.0");
        
        this.hoursWorked = hoursWorked;
    }
    
    public double getHoursWorked(){
        return hoursWorked;
    }
    
    public double earnings(){
        if (hoursWorked > 40){
            return (hourlyWage * 40) + (hoursWorked - 40) * (hourlyWage * 1.5);
        }
        return hourlyWage * hoursWorked;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s    %s: %.2f%n    %s: %.2f%n    %s: $%.2f%n",
                "Hourly Employee", super.toString(),
                "Hourly Wage", getHourlyWage(),
                "Hours Worked", getHoursWorked(),
                "Earnings", earnings());
    }
}

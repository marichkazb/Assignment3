package assignment3.Employee;

public class Employee {

    private final String ID;
    private String name;
    private final double GROSS_SALARY;
    private double currentGrossSalary;

    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.GROSS_SALARY = Truncate.truncateToTwoDigits(grossSalary);
        this.currentGrossSalary = Truncate.truncateToTwoDigits(grossSalary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return this.GROSS_SALARY;
    }
    public double getCurrentGrossSalary() {
        return this.currentGrossSalary;
    }

    public void setCurrentGrossSalary(double currentGrossSalary) {
        this.currentGrossSalary = Truncate.truncateToTwoDigits(currentGrossSalary);
    }

    public String getID() {
        return ID;
    }

    //Two employees are equals if they have the same ID
    public boolean equals(Object anotherObject) {
        if (anotherObject == this) {
            return true;
        }
        if (anotherObject == null) {
            return false;
        }
        if (anotherObject instanceof Employee) {
            Employee otherEmployee = (Employee) anotherObject;
            return this.ID.equals(otherEmployee.getID());
        } else {
            return false;
        }
    }

    public String toString() {
        return this.name + String.format("'s gross salary is %.2f SEK per month.", (this.getCurrentGrossSalary()));
    }

    public double getNetSalary() {
        return Truncate.truncateToTwoDigits(this.currentGrossSalary - (this.currentGrossSalary * 0.1));
    }
}

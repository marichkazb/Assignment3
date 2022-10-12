package assignment3.Employee;

public class Employee {

    private final String ID;
    private String name;
    private final double BASE_GROSS_SALARY;
    private double grossSalary;

    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.BASE_GROSS_SALARY = Truncate.truncateToTwoDigits(grossSalary);
        this.grossSalary = Truncate.truncateToTwoDigits(grossSalary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseGrossSalary() {
        return BASE_GROSS_SALARY;
    }
    public double getGrossSalary() {
        return this.grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = Truncate.truncateToTwoDigits(grossSalary);
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
        return this.name + String.format("'s gross salary is %.2f SEK per month.", (this.grossSalary));
    }

    public double getNetSalary() {
        return Truncate.truncateToTwoDigits(this.grossSalary - (this.grossSalary * 0.1));
    }

    public boolean hasEmptyID() {
        return this.ID.isEmpty();
    }
    public boolean hasEmptyName() {
        return this.name.isEmpty();
    }
    public boolean hasInvalidSalary() {
        return this.grossSalary <= 0;
    }
}

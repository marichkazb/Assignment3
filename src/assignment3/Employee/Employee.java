package assignment3.Employee;

import assignment3.Truncate;

public class Employee {

    private final String ID;
    private String name;
    private double BASE_GROSS_SALARY;

    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.BASE_GROSS_SALARY = Truncate.truncateToTwoDigits(grossSalary);
    }

    public String getName() {
        return name;
    }

    //Regular employees and subclasses (e.g. Manager): Can change name.
    public String updateEmployeeName(String name) {
        this.name = name;
        return successfulUpdate();
    }

    //Regular employees and subclasses (e.g. Manager): Can change gross salary.
    public String updateGrossSalary(double BASE_GROSS_SALARY) {
        this.BASE_GROSS_SALARY = BASE_GROSS_SALARY;
        return successfulUpdate();
    }

    public String successfulUpdate() {
        return "Employee " + ID + " was updated successfully";
    }

    public double getBaseGrossSalary() {
        return BASE_GROSS_SALARY;
    }

    public double getGrossSalary() {
        return this.BASE_GROSS_SALARY;
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
        return this.name + "'s gross salary is " + String.format("%.2f", this.getGrossSalary()) + " SEK per month.";
    }

    public double getNetSalary() {
        return Truncate.truncateToTwoDigits(this.getGrossSalary() - (this.getGrossSalary() * 0.1));
    }

    public boolean hasEmptyID() {
        return this.ID.isEmpty();
    }

    public boolean hasEmptyName() {
        return this.name.isBlank();
    }

    public boolean hasInvalidSalary() {
        return this.getGrossSalary() <= 0;
    }
}

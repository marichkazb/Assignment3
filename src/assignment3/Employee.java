package assignment3;

import java.util.Objects;

public class Employee implements Comparable<Employee>{

    private final String ID;
    private String name;
    private double BASE_GROSS_SALARY;

    public Employee(String ID, String name, double grossSalary) throws EmployeeException {
        checkIDValidity(ID);
        checkNameValidity(name);
        checkBaseGrossSalaryValidity(grossSalary);

        this.ID = ID;
        this.name = name;
        this.BASE_GROSS_SALARY = Truncate.truncateToTwoDigits(grossSalary);
    }

    public void checkIDValidity(String ID) throws EmployeeException {
        if (ID.isEmpty()) {
            throw new EmployeeException("ID cannot be blank.");
        }
    }
    public void checkNameValidity(String name) throws EmployeeException {
        if (name.isBlank()) {
            throw new EmployeeException("Name cannot be blank.");
        }
    }
    public void checkBaseGrossSalaryValidity(double BASE_GROSS_SALARY) throws EmployeeException {
        if (BASE_GROSS_SALARY <= 0) {
            throw new EmployeeException("Salary must be greater than zero.");
        }
    }

    public String getName() {
        return name;
    }

    //Regular employees and subclasses (e.g. Manager): Can change name.
    public String updateEmployeeName(String name) throws EmployeeException {
        checkNameValidity(name);
        this.name = name;
        return successfulUpdate();
    }

    //Regular employees and subclasses (e.g. Manager): Can change gross salary.
    public String updateGrossSalary(double BASE_GROSS_SALARY) throws EmployeeException {
        checkBaseGrossSalaryValidity(BASE_GROSS_SALARY);
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
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return this.name + "'s gross salary is " + String.format("%.2f", this.getGrossSalary()) + " SEK per month.";
    }

    public double getNetSalary() {
        return Truncate.truncateToTwoDigits(this.getGrossSalary() - (this.getGrossSalary() * 0.1));
    }

   public int compareTo(Employee otherEmployee) {
       double myGrossSalary = this.getGrossSalary();
       double otherGrossSalary = otherEmployee.getGrossSalary();
       if (myGrossSalary > otherGrossSalary) {
           return 1;
       } else if (myGrossSalary == otherGrossSalary) {
           return 0;
       } else {
           return -1;
       }
   }
}

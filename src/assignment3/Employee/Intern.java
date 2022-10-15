package assignment3.Employee;

import assignment3.EmployeeException;
import assignment3.Truncate;

public class Intern extends Employee {
    private int GPA;

    public Intern(String ID, String name, double grossSalary, int GPA) throws EmployeeException {
        super(ID, name, grossSalary);
        checkGPAValidity(GPA);
        this.GPA = GPA;
    }

    private void checkGPAValidity(int GPA) throws EmployeeException {
        if(GPA > 10 || GPA < 0) {
            throw new EmployeeException(GPA + " outside range. Must be between 0-10.");
        }
    }

    public String updateInternGPA(int GPA) throws EmployeeException {
        checkGPAValidity(GPA);
        this.GPA = GPA;
        return successfulUpdate();
    }

    public String toString() {
        return super.toString() + " GPA: " + this.GPA;
    }

    public double getGrossSalary() {
        int BONUS_SALARY = 1000;
        if (this.GPA <= 5) {
            return 0;
        } else if (this.GPA >= 8) {
            return super.getGrossSalary() + BONUS_SALARY;
        } else {
            return super.getGrossSalary();
        }
    }

    @Override
    public double getNetSalary() {
        return Truncate.truncateToTwoDigits(this.getGrossSalary());
    }

}

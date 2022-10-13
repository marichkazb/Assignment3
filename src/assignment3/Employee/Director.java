package assignment3.Employee;

import assignment3.Depts;
import assignment3.EmployeeException;

public class Director extends Manager {
    private String department;

    public Director(String ID, String name, double grossSalary, String degree, String department) throws EmployeeException {
        super(ID, name, grossSalary, degree);
        this.department = department;
        checkDepartmentValidity();
    }

    private void checkDepartmentValidity() throws EmployeeException {
        if (!(this.department.equals(Depts.BUSINESS.toString())
                || this.department.equals(Depts.HUMAN_RESOURCES.toString())
                || this.department.equals(Depts.TECHNICAL.toString()))) {
            throw new EmployeeException("Department must be one of the options: Business, Human Resources or Technical.");
        }
    }

    public String getDepartment() {
        return this.department;
    }

    //Director: Can change his/her department.
    public String updateDirectorDept(String department) throws EmployeeException {
        this.department = department;
        checkDepartmentValidity();
        return successfulUpdate();
    }

    @Override
    public String toString() {
        return super.toString() + " Dept: " + this.department;
    }

    @Override
    public double getGrossSalary() {
        int ADDITIONAL_SALARY = 5000;
        return super.getGrossSalary() + ADDITIONAL_SALARY;
    }

    @Override
    public double getNetSalary() {
        double netSalary;
        if (getGrossSalary() < 30000) {
            return super.getNetSalary();
        } else if (getGrossSalary() < 50000) {
            netSalary = getGrossSalary() * 0.8;
        } else {
            double amountAboveLimit = getGrossSalary() - 30000;
            netSalary = getGrossSalary() - (30000 * 0.2) - amountAboveLimit * 0.4;
        }
        return netSalary;
    }


}

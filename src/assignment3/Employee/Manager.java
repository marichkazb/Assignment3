package assignment3.Employee;

import assignment3.Degrees;
import assignment3.EmployeeException;
import assignment3.Truncate;

import java.util.HashMap;

public class Manager extends Employee {
    private String degree;

    public Manager(String ID, String name, double grossSalary, String degree) throws EmployeeException {
        super(ID, name, grossSalary);
        this.degree = degree;
        checkDegreeValidity();
    }

    private void checkDegreeValidity() throws EmployeeException {
        for(Degrees degree : Degrees.values()){
            if(degree.toString().equals(this.degree)){
                return;
            }
        }
        throw new EmployeeException("Degree must be one of the options: BSc, MSc or PhD.");
    }

    public String getDegree() {
        return this.degree;
    }

    //Manager and children (e.g. Director) can change his/her degree.
    public String updateManagerDegree(String degree) throws EmployeeException {
        this.degree = degree;
        checkDegreeValidity();
        return successfulUpdate();
    }

    @Override
    public String toString() {
        return this.degree + " " + super.toString();
    }

    public double getGrossSalary() {
        HashMap<String, Double> degreeMultiplier = new HashMap<String, Double>();

        degreeMultiplier.put(Degrees.BSC.toString(), 1.1);
        degreeMultiplier.put(Degrees.MSC.toString(), 1.2);
        degreeMultiplier.put(Degrees.PHD.toString(), 1.35);

        return Truncate.truncateToTwoDigits(super.getGrossSalary() * degreeMultiplier.get(this.degree));
    }

}

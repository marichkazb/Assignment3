package assignment3.Employee;

import assignment3.Degrees;
import assignment3.ExceptionsHandler;
import assignment3.Truncate;

import java.util.HashMap;

public class Manager extends Employee {
    private String degree;

    public Manager(String ID, String name, double grossSalary, String degree) throws ExceptionsHandler {
        super(ID, name, grossSalary);
        this.degree = degree;
    }

    public String getDegree() {
        return this.degree;
    }

    //Manager and children (e.g. Director) can change his/her degree.
    public String updateManagerDegree(String degree) {
        this.degree = degree;
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

    public boolean hasInvalidDegree() {
        return !(this.degree.equals(Degrees.BSC.toString()) || this.degree.equals(Degrees.MSC.toString()) || this.degree.equals(Degrees.PHD.toString()));
    }
}

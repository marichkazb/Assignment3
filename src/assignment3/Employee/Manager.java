package assignment3.Employee;
import java.util.HashMap;

public class Manager extends Employee {
    private String degree;
    public Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);
        this.degree = degree;
    }

    public String getDegree() { return this.degree; }
    public String setDegree(String degree) { return this.degree = degree; }

    @Override
    public String toString() {
        return this.degree + " " + super.toString();
    }

    public double getGrossSalary() {
        HashMap<String, Double> degreesCollection = new HashMap<String, Double>();
        degreesCollection.put("BSc", 1.1);
        degreesCollection.put("MSc", 1.2);
        degreesCollection.put("PhD", 1.35);
        return super.getGrossSalary() * degreesCollection.get(this.degree);
    }

    public boolean hasInvalidDegree() {
        return !(this.degree.equals("BSc") || this.degree.equals("MSc") || this.degree.equals("PhD"));
    }
}

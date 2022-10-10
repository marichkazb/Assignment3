package assignment3.Employee;
import java.util.HashMap;

public class Manager extends Employee {
    private String degree;
    public Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);
        this.degree = degree;
        this.calculateCurrentGrossSalary();
    }

    public String getDegree() { return this.degree; }
    public String setDegree(String degree) { return this.degree = degree; }

    @Override
    public String toString() {
        return this.degree + " " + super.getName() + "'s gross salary is " + this.getCurrentGrossSalary() + " SEK per month.";
    }

    public void calculateCurrentGrossSalary() {
        HashMap<String, Double> degreesCollection = new HashMap<String, Double>();
        degreesCollection.put("BSc", 0.1);
        degreesCollection.put("MSc", 0.2);
        degreesCollection.put("PhD", 0.35);

        double bonus = super.getCurrentGrossSalary() * degreesCollection.get(this.degree);
        this.setCurrentGrossSalary(super.getCurrentGrossSalary() + bonus);
    }
}

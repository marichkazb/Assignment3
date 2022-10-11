package assignment3.Employee;

public class Director extends Manager {
    private String department;
    public Director(String ID, String name, double grossSalary, String degree, String department) {
        super(ID, name, grossSalary, degree);
        this.department = department;
    }

    public String getDepartment() { return this.department; }

    public String setDepartment(String department) { return this.department = department; }

    @Override
    public String toString() {
        return super.getDegree() + " " + super.getName() + "'s gross salary is " + String.format("%.2f", (this.getCurrentGrossSalary())) + " SEK per month."
        + " Dept: " + this.department;
    }

    @Override
    public void calculateCurrentGrossSalary() {
        int ADDITIONAL_SALARY = 5000;
        super.calculateCurrentGrossSalary();
        this.setCurrentGrossSalary(this.getCurrentGrossSalary() + ADDITIONAL_SALARY);
    }
    @Override
    public double getNetSalary() {
        double netSalary;
        if (this.getCurrentGrossSalary() > 30000 && this.getCurrentGrossSalary() < 50000) {
            netSalary = this.getCurrentGrossSalary() - (this.getCurrentGrossSalary() * 0.2);
        } else if (this.getCurrentGrossSalary() > 50000) {
            double amountAboveLimit = this.getCurrentGrossSalary() - 30000;
            netSalary = this.getCurrentGrossSalary() - (30000 * 0.2) - (amountAboveLimit * 0.4);
        } else {
            netSalary = super.getNetSalary();
        }
        return Truncate.truncateToTwoDigits(netSalary);
    }
}

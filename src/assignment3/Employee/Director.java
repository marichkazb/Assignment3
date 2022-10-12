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
        if (getGrossSalary() > 30000) {
            return super.getNetSalary();
        } else if (getGrossSalary() < 50000) {
            netSalary = getGrossSalary() * 0.8;
        } else {
            double amountAboveLimit = getGrossSalary() - 30000;
            netSalary = getGrossSalary() - (30000 * 0.2) - amountAboveLimit * 0.4;
        }
        return Truncate.truncateToTwoDigits(netSalary);
    }
}

package assignment3.Employee;

public class Intern extends Employee {
    private int GPA;
    public Intern(String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary);
        this.GPA = GPA;
        this.calculateCurrentGrossSalary();
    }

    public int getGPA() { return GPA; }

    public void setGPA(int GPA) { this.GPA = GPA; }

    public String toString() {
        return super.toString() + " GPA: " + this.GPA;
    }

    public void calculateCurrentGrossSalary() {
        int BONUS_SALARY = 1000;
        if (this.GPA <= 5) {
            this.setGrossSalary(0);
        } else if (this.GPA >= 8) {
            this.setGrossSalary(this.getGrossSalary() + BONUS_SALARY);
        } else {
            this.setGrossSalary(super.getGrossSalary());
        }
    }

    @Override
    public double getNetSalary() {
        return Truncate.truncateToTwoDigits(this.getGrossSalary());
    }
}

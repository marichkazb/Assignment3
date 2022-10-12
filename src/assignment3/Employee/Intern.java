package assignment3.Employee;

import assignment3.Truncate;

public class Intern extends Employee {
    private int GPA;

    public Intern(String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary);
        this.GPA = GPA;
    }

    public int getGPA() {
        return GPA;
    }

    public String updateInternGPA(int GPA) {
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

    public boolean hasInvalidGrade() {
        return this.GPA > 10 || this.GPA < 0;
    }
}

package assignment3;

import assignment3.Employee.Employee;
import assignment3.Employee.Manager;
import assignment3.Employee.Director;
import assignment3.Employee.Intern;

import java.util.ArrayList;
import java.util.Objects;

public class Company {
    private ArrayList<Employee> employeeList;
    private static final String EOL = System.lineSeparator();

    public Company() {
        this.employeeList = new ArrayList<Employee>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(employeeList, company.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeList);
    }

    @Override
    public String toString() {
        return "Company{" +
                "employeeList=" + employeeList +
                '}';
    }

    //create employees overloading
    public String createEmployee(String ID, String employeeName, double grossSalary) {
        Employee newEmployee = new Employee(ID, employeeName, grossSalary);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree) {
        Employee newEmployee = new Manager(ID, employeeName, grossSalary, degree);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) {
        Employee newEmployee = new Director(ID, employeeName, grossSalary, degree, department);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, int GPA) {
        Employee newEmployee = new Intern(ID, employeeName, grossSalary, GPA);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    private String registeredString(String ID) {
        return "Employee " + ID + " was registered successfully.";
    }

    public void registerEmployee(String ID, String Name, int grossSalary) {
        Employee newEmployee = new Employee(ID, Name, grossSalary);
        this.employeeList.add(newEmployee);
    }

    public String removeEmployee(String ID) {


        Employee desiredEmployee = findEmployee(ID);
        if (desiredEmployee != null) {
            employeeList.remove(desiredEmployee);
            return "Employee " + ID + " was successfully removed.";
        } else {
            //todo Otherwise, refer to the possible error cases described in Epic Feature 2 (Exceptions).
            return "";
        }
    }

    public double getNetSalary(String ID) {
        Employee desiredEmployee = findEmployee(ID);
        return desiredEmployee.getNetSalary();
    }

    public String printEmployee(String ID) {
        return findEmployee(ID).toString();
    }

    public void updateName(String ID, String newName) {

    }

    public void updateSalary(String ID, double newSalary) {

    }

    public String printAllEmployees() {
        String companyEmployees = "All registered employees:";

        for (Employee eachEmployee : employeeList) {
            companyEmployees = companyEmployees.concat(EOL + eachEmployee.toString());
        }

        return companyEmployees;
    }


    public double calculateExpensesGross() {

        return 0.0;
    }

    public double calculateExpensesNet() {

        return 0.0;
    }

    public int getNumberOfEmployees() {

        return 0;
    }

    //maybe it's possible to use forEach method, then you will not need for loop
    private Employee findEmployee(String ID) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee currentEmployee = employeeList.get(i);
            if (currentEmployee.getID().equals(ID)) {
                return currentEmployee;
            }
        }
        return null;
    }

}

package assignment3;

import java.util.ArrayList;
import java.util.Objects;

public class Company {
    private ArrayList<Employee> employeeList;

    public Company() {
        this.employeeList = new ArrayList<>();
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

    public String createEmployee(String employeeID, String employeeName, double grossSalary) {
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        this.employeeList.add(newEmployee);
        return "Employee "+employeeID+" was registered successfully.";
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

    public String printEmployee(String ID) {
        return findEmployee(ID).toString();
    }

    public void updateName(String ID, String newName) {

    }

    public void updateSalary(String ID, double newSalary) {

    }

    public double getNetSalary(String employeeID){

        return 0.0;
    }

    public String retrieveAllEmployees() {
        String companyEmployees = "All registered employees:";

        for (Employee eachEmployee : employeeList) {
            companyEmployees = companyEmployees.concat(System.lineSeparator() + eachEmployee.toString());
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

    private Employee findEmployee(String ID) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee currentEmployee = employeeList.get(i);
            if (currentEmployee.getId().equals(ID)) {
                return currentEmployee;
            }
        }
        return null;
    }

}

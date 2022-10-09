package assignment3;

import java.util.ArrayList;
import java.util.Objects;

public class Company {
    private ArrayList<Employee> employeeList;

    public Company() {
        employeeList = new ArrayList<Employee>();
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

    public void registerEmployee(String ID, String Name, int grossSalary){

    }

    public String removeEmployee(String ID){

        return "";
    }

    public Employee retrieveEmployee (String ID){
        Employee employee = new Employee();

        return employee;
    }

    public void updateName( String ID, String newName) {

    }

    public void updateSalary (String ID, double newSalary){

    }

    public String retrieveAllEmployees() {

        return "";
    }

    public double calculateExpensesGross() {

        return 0.0;
    }

    public double calculateExpensesNet(){

        return 0.0;
    }

    public int getNumberOfEmployees(){

        return 0;
    }

}

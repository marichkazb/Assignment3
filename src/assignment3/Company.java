package assignment3;

import assignment3.Employee.*;

import java.util.*;
import java.util.Collections;

public class Company {
    private ArrayList<Employee> employeeList;
    private static final String EOL = System.lineSeparator();

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

    //CREATE EMPLOYEES OVERLOADING
    public String createEmployee(String ID, String employeeName, double grossSalary) throws Exception {

        checkEmployeeAlreadyRegistered(ID);

        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary);
        this.employeeList.add(newEmployee);

        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree) throws Exception {
        checkEmployeeAlreadyRegistered(ID);

        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, degree);
        this.employeeList.add(newEmployee);

        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) throws Exception {
        checkEmployeeAlreadyRegistered(ID);

        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, degree, department);
        this.employeeList.add(newEmployee);

        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, int GPA) throws Exception {

        checkEmployeeAlreadyRegistered(ID);

        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, GPA);
        this.employeeList.add(newEmployee);

        return this.registeredString(ID);
    }

    private String registeredString(String ID) {
        return "Employee " + ID + " was registered successfully.";
    }

    // FIND EMPLOYEE
    private Employee findEmployeeObject(String ID) {
        for (Employee employee : employeeList) {
            if (employee.getID().equals(ID)) {
                return employee;
            }
        }
        return null;
    }

    private Employee findEmployee(String ID) throws CompanyException {
        if (findEmployeeObject(ID) != null) {
            return findEmployeeObject(ID);
        } else {
            throw new CompanyException("Employee " + ID + " was not registered yet.");
        }
    }

    public void checkEmployeeAlreadyRegistered(String ID) throws CompanyException {
        if (findEmployeeObject(ID) != null) {
            throw new CompanyException("Cannot register. ID " + ID + " is already registered.");
        }
    }


    //UPDATE EMPLOYEES
    public String updateEmployeeName(String ID, String newName) throws Exception {
        return findEmployee(ID).updateEmployeeName(newName);
    }

    public String updateGrossSalary(String ID, double newGrossSalary) throws Exception {
        return findEmployee(ID).updateGrossSalary(newGrossSalary);
    }

    public String updateInternGPA(String ID, int newGPA) throws Exception {
        return ((Intern) findEmployee(ID)).updateInternGPA(newGPA);
    }


    public String updateManagerDegree(String ID, String newDegree) throws Exception {
        return ((Manager) findEmployee(ID)).updateManagerDegree(newDegree);
    }


    public String updateDirectorDept(String ID, String newDept) throws Exception {
        return ((Director) findEmployee(ID)).updateDirectorDept(newDept);
    }

    // PROMOTE EMPLOYEES
    public String promoteToManager(String ID, String degree) throws Exception {
        Employee currentEmployee = findEmployee(ID);
        Employee newManager = EmployeeFactory.createEmployee(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), degree);
        employeeList.remove(currentEmployee);
        employeeList.add(newManager);
        return ID + " promoted successfully to Manager.";
    }

    public String promoteToDirector(String ID, String degree, String department) throws Exception {
        Employee currentEmployee = findEmployee(ID);
        Employee newDirector = EmployeeFactory.createEmployee(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), degree, department);
        employeeList.remove(currentEmployee);
        employeeList.add(newDirector);
        return ID + " promoted successfully to Director.";
    }

    public String promoteToIntern(String ID, int GPA) throws Exception {
        Employee currentEmployee = findEmployee(ID);
        Employee newIntern = EmployeeFactory.createEmployee(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), GPA);
        employeeList.remove(currentEmployee);
        employeeList.add(newIntern);
        return ID + " promoted successfully to Intern.";
    }

    public HashMap<String, Integer> mapEachDegree() throws Exception {

        HashMap<String, Integer> degreesMap = new HashMap<>();

        checkEmployeeListEmpty();

        for (Employee currentEmployee : employeeList) {
            if (currentEmployee instanceof Manager) {
                String degree = ((Manager) currentEmployee).getDegree();
                int currentAmount = degreesMap.getOrDefault(degree, 0);
                degreesMap.put(degree, currentAmount + 1);
            }
        }

        return degreesMap;

    }

    // EMPLOYEE ACTIONS

    public String printEmployee(String ID) throws Exception {
        return findEmployee(ID).toString();
    }

    public void checkEmployeeListEmpty() throws CompanyException {
        if (employeeList.isEmpty()) {
            throw new CompanyException("No employees registered yet.");
        }
    }

    public String removeEmployee(String ID) throws Exception {
        employeeList.remove(findEmployee(ID));
        return "Employee " + ID + " was successfully removed.";
    }

    public double getNetSalary(String ID) throws Exception {
        return findEmployee(ID).getNetSalary();
    }

    public double getTotalNetSalary() throws Exception {
        double totalNetSalary = 0;

        checkEmployeeListEmpty();

        for (Employee employee : employeeList) {
            totalNetSalary = totalNetSalary + employee.getNetSalary();
        }
        return totalNetSalary;
    }

    public String printAllEmployees() throws Exception {
        return printList("All registered employees:");
    }
    public String printSortedEmployees() throws Exception {
        Collections.sort(this.employeeList);
        return printList("Employees sorted by gross salary (ascending order):");
    }

    public String printList (String title) throws Exception {
        checkEmployeeListEmpty();
        String companyEmployees = title + EOL;

        for (Employee eachEmployee : employeeList) {
            companyEmployees = companyEmployees.concat(eachEmployee.toString() + EOL);
        }
        return companyEmployees;
    }
}


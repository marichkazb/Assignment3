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

    //CREATE EMPLOYEES OVERLOADING
    public String createEmployee(String ID, String employeeName, double grossSalary) throws CompanyException, EmployeeException {
        checkEmployeeAlreadyRegistered(ID);
        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, int GPA) throws CompanyException, EmployeeException {
        checkEmployeeAlreadyRegistered(ID);
        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, GPA);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree) throws CompanyException, EmployeeException {
        checkEmployeeAlreadyRegistered(ID);
        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, degree);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) throws CompanyException, EmployeeException {
        checkEmployeeAlreadyRegistered(ID);
        Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, degree, department);
        this.employeeList.add(newEmployee);
        return this.registeredString(ID);
    }

    private String registeredString(String ID) {
        return "Employee " + ID + " was registered successfully.";
    }

    public String promoteToIntern(String ID, int GPA) throws CompanyException, EmployeeException {
        Employee currentEmployee = findEmployee(ID);
        Employee newIntern = EmployeeFactory.createEmployee(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), GPA);
        employeeList.remove(currentEmployee);
        employeeList.add(newIntern);
        return ID + " promoted successfully to Intern.";
    }

    // PROMOTE EMPLOYEES
    public String promoteToManager(String ID, String degree) throws CompanyException, EmployeeException {
        Employee currentEmployee = findEmployee(ID);
        Employee newManager = EmployeeFactory.createEmployee(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), degree);
        employeeList.remove(currentEmployee);
        employeeList.add(newManager);
        return ID + " promoted successfully to Manager.";
    }

    public String promoteToDirector(String ID, String degree, String department) throws CompanyException, EmployeeException {
        Employee currentEmployee = findEmployee(ID);
        Employee newDirector = EmployeeFactory.createEmployee(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), degree, department);
        employeeList.remove(currentEmployee);
        employeeList.add(newDirector);
        return ID + " promoted successfully to Director.";
    }


    //UPDATE EMPLOYEES
    public String updateEmployeeName(String ID, String newName) throws CompanyException, EmployeeException {
        return findEmployee(ID).updateEmployeeName(newName);
    }

    public String updateGrossSalary(String ID, double newGrossSalary) throws CompanyException, EmployeeException {
        return findEmployee(ID).updateGrossSalary(newGrossSalary);
    }

    public String updateInternGPA(String ID, int newGPA) throws CompanyException, EmployeeException {
        return ((Intern) findEmployee(ID)).updateInternGPA(newGPA);
    }


    public String updateManagerDegree(String ID, String newDegree) throws CompanyException, EmployeeException {
        return ((Manager) findEmployee(ID)).updateManagerDegree(newDegree);
    }


    public String updateDirectorDept(String ID, String newDept) throws CompanyException, EmployeeException {
        return ((Director) findEmployee(ID)).updateDirectorDept(newDept);
    }

    // SINGLE EMPLOYEE ACTIONS

    public String printEmployee(String ID) throws CompanyException {
        return findEmployee(ID).toString();
    }

    public String removeEmployee(String ID) throws CompanyException {
        employeeList.remove(findEmployee(ID));
        return "Employee " + ID + " was successfully removed.";
    }

    public double getNetSalary(String ID) throws CompanyException {
        return findEmployee(ID).getNetSalary();
    }

    // FIND EMPLOYEE
    private Employee findEmployeeOrNull(String ID) {
        for (Employee employee : employeeList) {
            if (employee.getID().equals(ID)) {
                return employee;
            }
        }
        return null;
    }

    private Employee findEmployee(String ID) throws CompanyException {
        if (findEmployeeOrNull(ID) != null) {
            return findEmployeeOrNull(ID);
        } else {
            throw new CompanyException("Employee " + ID + " was not registered yet.");
        }
    }


    public String printAllEmployees() throws CompanyException {
        return printList("All registered employees:");
    }

    public String printSortedEmployees() throws CompanyException {
        Collections.sort(this.employeeList);
        return printList("Employees sorted by gross salary (ascending order):");
    }


    public HashMap<String, Integer> mapEachDegree() throws CompanyException {

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


    public double getTotalNetSalary() throws CompanyException {
        double totalNetSalary = 0;

        checkEmployeeListEmpty();

        for (Employee employee : employeeList) {
            totalNetSalary = totalNetSalary + employee.getNetSalary();
        }
        return totalNetSalary;
    }


    private String printList(String title) throws CompanyException {
        checkEmployeeListEmpty();
        String companyEmployees = title + EOL;

        for (Employee eachEmployee : employeeList) {
            companyEmployees = companyEmployees.concat(eachEmployee.toString() + EOL);
        }
        return companyEmployees;
    }


    private void checkEmployeeAlreadyRegistered(String ID) throws CompanyException {
        if (findEmployeeOrNull(ID) != null) {
            throw new CompanyException("Cannot register. ID " + ID + " is already registered.");
        }
    }


    private void checkEmployeeListEmpty() throws CompanyException {
        if (employeeList.isEmpty()) {
            throw new CompanyException("No employees registered yet.");
        }
    }

}


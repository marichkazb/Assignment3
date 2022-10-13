package assignment3;

import assignment3.Employee.*;

import java.util.ArrayList;
import java.util.HashMap;
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


    public void checkEmployeeAlreadyRegistered(String ID) throws Exception {
        if(employeeExists(ID)){
            throw new Exception("Cannot register. ID " + ID + " is already registered.");
        }
    }

    public boolean employeeExists(String ID) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee currentEmployee = employeeList.get(i);
            if (currentEmployee.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    private String registeredString(String ID) {
        return "Employee " + ID + " was registered successfully.";
    }

    public void registerEmployee(String ID, String Name, int grossSalary) {
        Employee newEmployee = new Employee(ID, Name, grossSalary);
        this.employeeList.add(newEmployee);
    }

    public String removeEmployee(String ID) throws Exception {


        Employee desiredEmployee = findEmployee(ID);
        employeeList.remove(desiredEmployee);
        return "Employee " + ID + " was successfully removed.";

    }

    public double getNetSalary(String ID) throws Exception {
        Employee desiredEmployee = findEmployee(ID);
        return desiredEmployee.getNetSalary();
    }

    public String printEmployee(String ID) throws Exception {
        return findEmployee(ID).toString();
    }

    public void updateName(String ID, String newName) {

    }

    public void updateSalary(String ID, double newSalary) {

    }

    public String printAllEmployees() throws Exception {

        String companyEmployees = "All registered employees:" + EOL;

        checkEmployeeListEmpty();

        for (Employee eachEmployee : employeeList) {
            companyEmployees = companyEmployees.concat(eachEmployee.toString() + EOL);
        }

        return companyEmployees;
    }

    public void checkEmployeeListEmpty() throws Exception {
        if (employeeList.isEmpty()) {
            throw new Exception("No employees registered yet.");
        }
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

    private Employee findEmployee(String ID) throws Exception {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee currentEmployee = employeeList.get(i);
            if (currentEmployee.getID().equals(ID)) {
                return currentEmployee;
            }
        }
        throw new Exception("Employee " + ID + " was not registered yet.");
    }

    public String promoteToManager(String ID, String degree) throws Exception {
        Employee currentEmployee = findEmployee(ID);
        Employee newManager = new Manager(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), degree);
        employeeList.remove(currentEmployee);
        employeeList.add(newManager);
        return ID + " promoted successfully to Manager.";
    }

    public String promoteToDirector(String ID, String degree, String department) throws Exception {
        Employee currentEmployee = findEmployee(ID);
        Employee newDirector = new Director(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), degree, department);
        employeeList.remove(currentEmployee);
        employeeList.add(newDirector);
        return ID + " promoted successfully to Director.";
    }

    public String promoteToIntern(String ID, int GPA) throws Exception {
        Employee currentEmployee = findEmployee(ID);
        Employee newIntern = new Intern(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getBaseGrossSalary(), GPA);
        employeeList.remove(currentEmployee);
        employeeList.add(newIntern);
        return ID + " promoted successfully to Intern.";
    }


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

    public HashMap<String, Integer> mapEachDegree() throws Exception {

        int BScCount = 0;
        int MScCount = 0;
        int PhDCount = 0;

        checkEmployeeListEmpty();

        for (Employee currentEmployee : employeeList) {
            if (currentEmployee instanceof Manager) {
                String degree = ((Manager) currentEmployee).getDegree();
                switch (Degrees.valueOf(degree.toUpperCase())) {
                    case BSC:
                        BScCount++;
                        break;
                    case MSC:
                        MScCount++;
                        break;
                    case PHD:
                        PhDCount++;
                        break;
                    default:
                        break;
                }
            }
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        if (BScCount != 0) {
            hashMap.put(Degrees.BSC.toString(), BScCount);
        }
        if (MScCount != 0) {
            hashMap.put(Degrees.MSC.toString(), MScCount);
        }
        if (PhDCount != 0) {
            hashMap.put(Degrees.PHD.toString(), PhDCount);
        }
        return hashMap;

    }

    public double getTotalNetSalary() throws Exception {
        double totalNetSalary = 0;

        checkEmployeeListEmpty();

        for (Employee employee : employeeList) {
            totalNetSalary = totalNetSalary + employee.getNetSalary();
        }
        return totalNetSalary;
    }

    public String printSortedEmployees() throws Exception {

        checkEmployeeListEmpty();

        return "Employees sorted by gross salary (ascending order):" + EOL;
    }
}


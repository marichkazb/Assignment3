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
    public String createEmployee(String ID, String employeeName, double grossSalary) {
        try {
            Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary);
            this.employeeList.add(newEmployee);
        } catch (Exception err) {
            System.out.println(err);
        }
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree) {
        try {
            Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, degree);
            this.employeeList.add(newEmployee);
        } catch (Exception err) {
            System.out.println(err);
        }
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) {
        try {
            Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, degree, department);
            this.employeeList.add(newEmployee);
        } catch (Exception err) {
            System.out.println(err);
        }
        return this.registeredString(ID);
    }

    public String createEmployee(String ID, String employeeName, double grossSalary, int GPA) {
        try {
            Employee newEmployee = EmployeeFactory.createEmployee(ID, employeeName, grossSalary, GPA);
            this.employeeList.add(newEmployee);
        } catch (Exception err) {
            System.out.println(err);
        }
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
        String companyEmployees = "All registered employees:" + EOL;

        for (Employee eachEmployee : employeeList) {
            companyEmployees = companyEmployees.concat(eachEmployee.toString() + EOL);
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


    public String promoteToManager(String ID, String degree) {
        Employee currentEmployee = findEmployee(ID);
        Employee newManager = new Manager(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getGrossSalary(), degree);
        employeeList.remove(currentEmployee);
        employeeList.add(newManager);
        return ID + " promoted successfully to Manager.";
    }

    public String promoteToDirector(String ID, String degree, String department) {
        Employee currentEmployee = findEmployee(ID);
        Employee newDirector = new Director(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getGrossSalary(), degree, department);
        employeeList.remove(currentEmployee);
        employeeList.add(newDirector);
        return ID + " promoted successfully to Director.";
    }

    public String promoteToIntern(String ID, int GPA) {
        Employee currentEmployee = findEmployee(ID);
        Employee newIntern = new Intern(currentEmployee.getID(), currentEmployee.getName(), currentEmployee.getGrossSalary(), GPA);
        employeeList.remove(currentEmployee);
        employeeList.add(newIntern);
        return ID + " promoted successfully to Intern.";
    }


    public String updateEmployeeName(String ID, String newName) {
        return findEmployee(ID).updateEmployeeName(newName);
    }

    public String updateGrossSalary(String ID, double newGrossSalary) {
        return findEmployee(ID).updateGrossSalary(newGrossSalary);
    }

    public String updateInternGPA(String ID, int newGPA) {
        return ((Intern) findEmployee(ID)).updateInternGPA(newGPA);
    }


    public String updateManagerDegree(String ID, String newDegree) {
        return ((Manager) findEmployee(ID)).updateManagerDegree(newDegree);
    }


    public String updateDirectorDept(String ID, String newDept) {
        return ((Director) findEmployee(ID)).updateDirectorDept(newDept);
    }

    public HashMap mapEachDegree() {

        int BScCount = 0;
        int MScCount = 0;
        int PhDCount = 0;

        for (Employee currentEmployee : employeeList) {
            if (currentEmployee instanceof Manager) {
                String degree = ((Manager) currentEmployee).getDegree();
                switch (Degrees.valueOf(degree)) {
                    case BSC:
                        BScCount++;
                        break;
                    case MSC:
                        MScCount++;
                        break;
                    case PHD:
                        PhDCount++;
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

    public double getTotalNetSalary() {
        double totalNetSalary = 0;
        for (Employee employee: employeeList) {
            totalNetSalary = totalNetSalary + employee.getNetSalary();
        }
        return totalNetSalary;
    }

    public String printSortedEmployees() {
        return "Employees sorted by gross salary (ascending order):" + EOL;
    }
}


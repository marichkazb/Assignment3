package assignment3.Employee;

import assignment3.EmployeeException;

public class EmployeeFactory {

    public static Employee createEmployee(String ID, String employeeName, double grossSalary) throws EmployeeException {
        return new Employee(ID, employeeName, grossSalary);
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree) throws EmployeeException {
        return new Manager(ID, employeeName, grossSalary, degree);
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) throws EmployeeException {
        return new Director(ID, employeeName, grossSalary, degree, department);
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, int GPA) throws EmployeeException {
        return new Intern(ID, employeeName, grossSalary, GPA);
    }


}

package assignment3.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(String ID, String employeeName, double grossSalary) throws Exception {
        Employee newEmployee = new Employee(ID, employeeName, grossSalary);
        return newEmployee;
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree) throws Exception {
        Employee newManager = new Manager(ID, employeeName, grossSalary, degree);
        return newManager;
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) throws Exception {
        Employee newDirector = new Director(ID, employeeName, grossSalary, degree, department);
        return newDirector;
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, int GPA) throws Exception {
        Employee newIntern = new Intern(ID, employeeName, grossSalary, GPA);
        return newIntern;
    }


}

package assignment3.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(String ID, String employeeName, double grossSalary) throws Exception {
        return new Employee(ID, employeeName, grossSalary);
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree) throws Exception {
        return new Manager(ID, employeeName, grossSalary, degree);
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) throws Exception {
        return new Director(ID, employeeName, grossSalary, degree, department);
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, int GPA) throws Exception {
        return new Intern(ID, employeeName, grossSalary, GPA);
    }


}

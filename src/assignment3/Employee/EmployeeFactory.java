package assignment3.Employee;

import assignment3.ExceptionsHandler;

public class EmployeeFactory {

    public static Employee createEmployee(String ID, String employeeName, double grossSalary) throws Exception {
        Employee newEmployee = new Employee(ID, employeeName, grossSalary);
        return newEmployee;
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree) throws Exception {
        Employee newManager = new Manager(ID, employeeName, grossSalary, degree);
//
//        if (((Manager) newManager).hasInvalidDegree()) {
//            throw new ExceptionsHandler("Degree must be one of the options: PhD, MSc or PhD.");
//        }
        return newManager;
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, String degree, String department) throws Exception {
        Employee newDirector = new Director(ID, employeeName, grossSalary, degree, department);
//        if (((Director) newDirector).hasInvalidDegree()) {
//            throw new ExceptionsHandler("Degree must be one of the options: PhD, MSc or PhD.");
//        }
//        if (((Director) newDirector).hasInvalidDepartment()) {
//            throw new ExceptionsHandler("Department must be one of the options: Business, Human Resources or Technical.");
//        }
        return newDirector;
    }

    public static Employee createEmployee(String ID, String employeeName, double grossSalary, int GPA) throws Exception {
        Employee newIntern = new Intern(ID, employeeName, grossSalary, GPA);
//        if (((Intern) newIntern).hasInvalidGrade()) {
//            throw new ExceptionsHandler(GPA + "outside range. Must be between 0-10.");
//        }
        return newIntern;
    }


}

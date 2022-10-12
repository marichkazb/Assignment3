package assignment3.Employee;

import assignment3.Company;

public class EmployeeMain {

    public static void main(String[] args) {
//        String employeeID = "IDc";
//        String employeeName = "Alan Turing";
//        String degree = "PhD";
//        String dept = "Technical";
//        double grossSalary = 62000.00;
//        Employee alanTuring = new Director(employeeID, employeeName, grossSalary, degree, dept);
//        System.out.println(alanTuring);
//        System.out.println(alanTuring.getNetSalary());
//
//        String employeeID1 = "IDb";
//        String employeeName1 = "Mary Keller";
//        String degree1 = "PhD";
//        double grossSalary1 = 62000.009; // Should be truncated when created. See specification.
//
//        Employee mary = new Manager(employeeID1, employeeName1, grossSalary1, degree1);
//        System.out.println(mary);
//        System.out.println(mary.getNetSalary());
//

        Employee employee = new Employee("34", "", 10000); //
        Employee manager =  new Manager("Emp2", "manager", 62000.008, "PhD"); //83700
        Employee director =  new Director("Emp2", "director", 62000, "PhD", "Technical"); //88700
        Employee intern =  new Intern("Emp2", "intern", 15000, 9); //16000

        System.out.println(employee);
        System.out.println(manager);
        System.out.println(director);
        System.out.println(intern);

        Company facade = new Company();
        facade.createEmployee("", "employee", 10000);
    }

}

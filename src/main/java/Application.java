import dao.EmployeeDao;
import dao.EmployeeDaoImpl;



import java.sql.*;
import model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();

        employee.setFirst_Name("Kim");
        employee.setLast_Name("Iven");
        employee.setGender("man");
        employee.setAge(31);
        employee.setCity_Id(2);
        System.out.println(employee);
        employeeDao.save(employee);
        System.out.println(employee);

        System.out.println(employeeDao.findById(21));
        employeeDao.deleteById((21));
        System.out.println(employeeDao.findById(21));

        Employee byId=employeeDao.findById(20);
        byId.setFirst_Name("Jack");
        byId.setLast_Name("Fill");
        employeeDao.update(byId);
        System.out.println(employeeDao.findById(20));

        employeeDao.findAll().forEach(System.out::println);
    }
}

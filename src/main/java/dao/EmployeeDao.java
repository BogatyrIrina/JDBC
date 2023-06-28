package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    Employee findById(int id) ;
    void update (Employee employee);
    void deleteById(int id);
    List<Employee> findAll();
}

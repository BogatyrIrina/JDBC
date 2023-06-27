package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    Employee findById(int id) throws SQLException;
    void create(Employee employee);
    void deleteById(Integer id);

    List<Employee>findAll();
}

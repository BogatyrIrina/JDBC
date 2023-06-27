package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final Connection connection;

    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Employee findById(int id)  {
        try (PreparedStatement preparedStatement=connection.prepareStatement("SELECT *FROM employe WHERE id =?")){
            preparedStatement.setInt(1,id);
            preparedStatement.setMaxRows(1);

            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Employee.create(resultSet);
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Employee employee) {

        try (PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO employe(first_Name,last_Name, gender,age,city_Id)VALUES (?,?,?,?,?)")){
            preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4,employee.getAge());
            preparedStatement.setInt(5, employee.getCityId());

            preparedStatement.executeUpdate();//Объединение и передача В БД

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM employe WHERE id= (?)")){

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> findAll() {
        try (PreparedStatement preparedStatement=connection.prepareStatement("SELECT *FROM employee ")) {
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Employee> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(Employee.create(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

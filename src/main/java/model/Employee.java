package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@AllArgsConstructor

@NoArgsConstructor

public class Employee {
    private  Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Integer cityId;



    public static Employee create(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirstName(resultSet.getString("first_Name"));
        employee.setLastName(resultSet.getString("last_Name"));
        employee.setGender(resultSet.getString("gender"));//названия колонок
        employee.setAge(resultSet.getInt("age"));
        employee.setCityId(resultSet.getInt("city_id"));
        return employee;
    }
}

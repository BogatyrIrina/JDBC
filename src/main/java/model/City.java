package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class City {
    public Integer cityId;
    public String cityName;


    public static City create(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setCityId(resultSet.getInt("id"));
        city.setCityName(resultSet.getString("CityName"));

        return city;
    }
}

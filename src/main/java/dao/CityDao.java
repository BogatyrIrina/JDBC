package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDao {
    void save(City city);

    City findByIdCity(int id);

    void updateCity(City city);


    void deleteById(int id);

    List<City> findAllCity();
}


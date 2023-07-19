import dao.CityDao;
import dao.CityDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

import model.City;
import model.Employee;

import java.util.ArrayList;


public class Application {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();

        City city = new City();
        city.setCity_name("TestTownes");
        city.setEmployee(new ArrayList<>());

        System.out.println(city);

        Employee employee = new Employee();
        employee.setCity(city);
        employee.setFirstName("Helen");
        employee.setLastName("Harper");
        employee.setGender("woman");
        employee.setAge(33);
        employee.setCityId(2);
        System.out.println(employee);
        employeeDao.save(employee);

        City byId = cityDao.findByIdCity(1);
        byId.setCity_name("Boston");
        cityDao.updateCity(byId);
        cityDao.updateCity(city);
        System.out.println(cityDao.findByIdCity(1));

        cityDao.findAllCity().forEach(System.out::println);
        cityDao.deleteById((0));

        System.out.println(cityDao.findByIdCity(26));
        System.out.println(city);
    }
}


import dao.EmployeeDaoImpl;


import java.sql.*;

public class Application {
    public Application() {
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        Connection conn = DriverManager.getConnection(url, user, password);
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(conn);//создание экземпляра класса PostDaoImpl и в конструкор передается connection
        System.out.println(employeeDao.findById(5));

        System.out.println(employeeDao.findById(9));

        employeeDao.findAll().forEach(System.out::println);
        //для пулл
    }
}

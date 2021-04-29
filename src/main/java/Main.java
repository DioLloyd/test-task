import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/staff";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String sqlRequest = "SELECT DEPARTMENT, SUM(SALARY) AS SALARY FROM EMPLOYEES GROUP BY DEPARTMENT";
            ResultSet resultSet = statement.executeQuery(sqlRequest);
            while (resultSet.next()) {
                String department = resultSet.getString("DEPARTMENT");
                int sum = resultSet.getInt("SALARY");
                System.out.println(department + ": " + sum);
            }
        }
    }
}

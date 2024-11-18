import java.sql.*;

public class MySQLExample {
    public static void main(String[] args) {
        // MySQL database credentials
        String url = "jdbc:mysql://localhost:3306/employee_db";  // Use your actual database name
        String user = "root";  // Use your MySQL username
        String password = "password";  // Use your MySQL password

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. Establish the connection to MySQL
            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            Statement stmt = conn.createStatement();

            // 3. Execute query
            String query = "SELECT * FROM employees";  // Use your actual table name
            ResultSet rs = stmt.executeQuery(query);

            // 4. Process the result set
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Position: " + rs.getString("position"));
                System.out.println("-----");
            }

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Handle the exception for missing MySQL driver
        }
    }
}

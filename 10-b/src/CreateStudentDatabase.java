import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateStudentDatabase {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "password");

            // Step 3: Execute a query to create a database
            Statement stmt = conn.createStatement();
            String sql = "CREATE DATABASE StudentDB";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

            // Step 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

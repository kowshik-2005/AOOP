import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateRegistrationTable {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDB", "root", "password");

            // Step 3: Execute a query to create a table
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE Registration (" +
                         "id INT NOT NULL PRIMARY KEY, " +
                         "name VARCHAR(100), " +
                         "address VARCHAR(200), " +
                         "program VARCHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully...");

            // Step 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    public static void main(String[] args) {
        // JDBC URL, username, and password for the PostgreSQL database
        String url = "jdbc:postgresql://localhost:5432/test"; // Replace 'test' with your database name
        String user = "your_username"; // Replace with your PostgreSQL username
        String password = "your_password"; // Replace with your PostgreSQL password

        // Connection object
        Connection conn = null;

        try {
            // Step 1: Register PostgreSQL JDBC driver (optional for newer versions)
            Class.forName("org.postgresql.Driver");

            // Step 2: Open a connection to the database
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: If connection is successful, print a success message
            if (conn != null) {
                System.out.println("Connected to the database");
            }

        } catch (SQLException e) {
            // Handle invalid username or password errors
            System.out.println("Invalid username or password");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle Class.forName() failure if driver is not found
            System.out.println("PostgreSQL JDBC Driver not found");
            e.printStackTrace();
        } finally {
            // Step 4: Close the connection (optional)
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStudentRecord {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDB", "root", "password");

            // Step 3: Execute a query to delete a record
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Registration WHERE id=101";
            stmt.executeUpdate(sql);
            System.out.println("Record deleted successfully...");

            // Step 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

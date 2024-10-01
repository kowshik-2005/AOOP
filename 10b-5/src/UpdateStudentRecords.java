import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateStudentRecords {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDB", "root", "password");

            // Step 3: Execute a query to update records
            Statement stmt = conn.createStatement();
            String sql1 = "UPDATE Registration SET program='Data Science' WHERE id=100";
            String sql2 = "UPDATE Registration SET program='Engineering' WHERE id=101";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            System.out.println("Records updated successfully...");

            // Step 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

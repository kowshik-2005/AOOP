import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudentRecords {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDB", "root", "password");

            // Step 3: Execute a query to display records
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String program = rs.getString("program");

                // Display the record
                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + address + ", Program: " + program);
            }

            // Step 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

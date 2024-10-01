import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudentRecords {
    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/StudentDB", "root", "password");

            // Step 3: Execute an insert query
            Statement stmt = conn.createStatement();
            String sql1 = "INSERT INTO Registration VALUES (100, 'John Doe', '123 Main St', 'Computer Science')";
            String sql2 = "INSERT INTO Registration VALUES (101, 'Jane Smith', '456 Oak St', 'Mathematics')";
            String sql3 = "INSERT INTO Registration VALUES (102, 'Alice Johnson', '789 Pine St', 'Physics')";
            String sql4 = "INSERT INTO Registration VALUES (103, 'Bob Brown', '321 Maple St', 'Biology')";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            System.out.println("Records inserted successfully...");

            // Step 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

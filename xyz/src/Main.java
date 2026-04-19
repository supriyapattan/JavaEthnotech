// Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Database details
        String url = "jdbc:mysql://localhost:5000/db1";
        String user = "root";
        String password = "@Supriya1015";

        Scanner sc = new Scanner(System.in);

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database Successfully!");

            // Take user input
            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String userPassword = sc.nextLine();

            // Insert Query using PreparedStatement
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, userPassword);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User Registered Successfully!\n");
            }

            // Display all users
            String selectQuery = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("---- Users Table Data ----");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Username: " + rs.getString("username") +
                                   ", Password: " + rs.getString("password"));
            }

            // Close resources
            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();
            sc.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
        } catch (SQLException e) {
            System.out.println("Database Error!");
            e.printStackTrace();
        }
    }
}
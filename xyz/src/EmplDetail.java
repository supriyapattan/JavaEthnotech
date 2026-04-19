// Required Packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmplDetail {

    // Database Details
    static String url = "jdbc:mysql://localhost:5000/company";
    static String user = "root";
    static String password = "@Supriya1015";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = null;

        try {
            // Load Driver (Optional in newer versions but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully!");

            while (true) {

                System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. View Employees");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // INSERT
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Designation: ");
                        String designation = sc.nextLine();

                        System.out.print("Enter Address: ");
                        String address = sc.nextLine();

                        System.out.print("Enter Phone: ");
                        String phone = sc.nextLine();

                        String insertQuery = "INSERT INTO employee (name, designation, address, phone) VALUES (?, ?, ?, ?)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

                        insertStmt.setString(1, name);
                        insertStmt.setString(2, designation);
                        insertStmt.setString(3, address);
                        insertStmt.setString(4, phone);

                        insertStmt.executeUpdate();
                        System.out.println("Employee Added Successfully!");

                        insertStmt.close();
                        break;

                    // UPDATE
                    case 2:
                        System.out.print("Enter Employee ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("1. Update Name");
                        System.out.println("2. Update Designation");
                        System.out.println("3. Update Address");
                        System.out.println("4. Update Phone");
                        System.out.print("Choose field: ");

                        int field = sc.nextInt();
                        sc.nextLine();

                        String column = "";

                        if (field == 1) column = "name";
                        else if (field == 2) column = "designation";
                        else if (field == 3) column = "address";
                        else if (field == 4) column = "phone";
                        else {
                            System.out.println("Invalid choice!");
                            break;
                        }

                        System.out.print("Enter New Value: ");
                        String newValue = sc.nextLine();

                        String updateQuery = "UPDATE employee SET " + column + " = ? WHERE id = ?";
                        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);

                        updateStmt.setString(1, newValue);
                        updateStmt.setInt(2, updateId);

                        int rowsUpdated = updateStmt.executeUpdate();

                        if (rowsUpdated > 0)
                            System.out.println("Employee Updated Successfully!");
                        else
                            System.out.println("Employee Not Found!");

                        updateStmt.close();
                        break;

                    // DELETE
                    case 3:
                        System.out.print("Enter Employee ID to Delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM employee WHERE id = ?";
                        PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);

                        deleteStmt.setInt(1, deleteId);

                        int rowsDeleted = deleteStmt.executeUpdate();

                        if (rowsDeleted > 0)
                            System.out.println("Employee Deleted Successfully!");
                        else
                            System.out.println("Employee Not Found!");

                        deleteStmt.close();
                        break;

                    // VIEW
                    case 4:
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

                        System.out.println("\n----- Employee List -----");
                        while (rs.next()) {
                            System.out.println(
                                "ID: " + rs.getInt("id") +
                                ", Name: " + rs.getString("name") +
                                ", Designation: " + rs.getString("designation") +
                                ", Address: " + rs.getString("address") +
                                ", Phone: " + rs.getString("phone")
                            );
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 5:
                        System.out.println("Program Ended.");
                        conn.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Option!");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
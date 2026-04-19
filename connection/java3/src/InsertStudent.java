import java.sql.*;

public class InsertStudent {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:5000/college",
                "root",
                "@Supriya1015"
            );

            String query = "INSERT INTO Student(name, branch) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "Anu");
            ps.setString(2, "ECE");

            ps.executeUpdate();

            System.out.println("Data inserted successfully");

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

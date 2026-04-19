import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MetroManagement {

    public static void main(String[] args) {

        try {

            // Database connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:5000/metro",
                    "root",
                    "@Supriya1015");

            Statement stmt = con.createStatement();

            // Display Stations
            System.out.println("Stations List:");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Stations");

            while (rs1.next()) {
                System.out.println(
                        rs1.getInt("station_id") + " " +
                        rs1.getString("station_name") + " " +
                        rs1.getString("location") + " " +
                        rs1.getString("platfomrms") + " " +
                        rs1.getInt("opening_year"));
            }

            // Display Trains
            System.out.println("\nTrains List:");
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Trains");

            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("train_id") + " " +
                        rs2.getString("train_name") + " " +
                        rs2.getInt("capacity") + " " +
                        rs2.getInt("station_id"));
            }

            // ---------------- DCL OPERATIONS ----------------

           stmt.executeUpdate("CREATE USER IF NOT EXISTS 'metro_staff'@'localhost' IDENTIFIED BY '@Supriya1015'");
            stmt.executeUpdate("GRANT SELECT ON metro.Stations TO 'metro_staff'@'localhost'");
            stmt.executeUpdate("GRANT INSERT ON metro.Trains TO 'metro_staff'@'localhost'");
            stmt.executeUpdate("REVOKE INSERT ON metro.Trains FROM 'metro_staff'@'localhost'");

            System.out.println("\nDCL Operations Completed");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

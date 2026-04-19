import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

public class ConnectionPoolDemo {

    public static void main(String[] args) {

        HikariDataSource ds = null;

        try {
            
            HikariConfig config = new HikariConfig();

            config.setJdbcUrl("jdbc:mysql://localhost:5000/college");
            config.setUsername("root");
            config.setPassword("@Supriya1015");

            
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            config.setConnectionTimeout(30000);

        
            ds = new HikariDataSource(config);

          
            Connection con = ds.getConnection();

         
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Student");

         
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch"));
            }

         
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         
            if (ds != null) {
                ds.close();
            }
        }
    }
}   
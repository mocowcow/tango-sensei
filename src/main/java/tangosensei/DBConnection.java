package tangosensei;

import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;

public class DBConnection {

    private static Properties prop;

    private static void loadProperties() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("dbconfig.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ResultSet query(String sql) {
        if (prop == null) {
            loadProperties();
        }
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        ResultSet rs = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //close
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;

    }

}

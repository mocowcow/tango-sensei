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

    public static Object[] getConnection(String sql) {
        if (prop == null) {
            loadProperties();
        }
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //do process
            while (rs.next()) {

                int id = rs.getInt("id");
                String q = rs.getString("q");
                String a = rs.getString("a");

                System.out.print("ID: " + id);
                System.out.print(", q: " + q);
                System.out.print(", a: " + a);
                System.out.print("\n");
            }
            //close
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        String sql = "select * from date";
        getConnection(sql);
    }
}

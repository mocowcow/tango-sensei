package tangosensei;

import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;
import java.util.LinkedList;

public class DBConnection {

    private static Properties prop;

    private static void loadProperties() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\tangosensei\\dbconfig.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static TestSet[] query(String sql) {
        if (prop == null) {
            loadProperties();
        }
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        TestSet[] ts = null;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //build ts from rs
            ts = buildTestSet(rs);
            //close
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ts;

    }

    private static TestSet[] buildTestSet(ResultSet rs) {
        LinkedList<TestSet> li = new LinkedList<>();
        try {
            while (rs.next()) {
                String q = rs.getString("q");
                String a = rs.getString("a");
                li.add(new TestSet(q, a));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return li.toArray(new TestSet[li.size()]);
    }

}

package tangosensei;

import java.sql.*;
import java.util.LinkedList;

public class DBConnection {

    private static final String DB_DRIVER = System.getenv("driver");
    private static final String DB_URL = System.getenv("url");
    private static final String DB_USER = System.getenv("user");
    private static final String DB_PW = System.getenv("password");

    public static TestSet[] query(String sql) {
        TestSet[] ts = null;
        try {
            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
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

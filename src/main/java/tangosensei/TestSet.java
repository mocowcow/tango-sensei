/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tangosensei;

import java.sql.*;
import java.util.LinkedList;
import java.util.Random;

public class TestSet {

    final private String question;
    final private String answer;

    public TestSet() {
        this("default q", "default a");
    }

    public TestSet(String q, String a) {
        this.question = q;
        this.answer = a;

    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    public static TestSet[] getDefaultTestSet() {
        TestSet[] ts = new TestSet[10];
        ts[0] = new TestSet("一日", "ついたち");
        ts[1] = new TestSet("二日", "ふつか");
        ts[2] = new TestSet("三日", "みっか");
        ts[3] = new TestSet("四日", "よっか");
        ts[4] = new TestSet("五日", "いつか");
        ts[5] = new TestSet("六日", "むいか");
        ts[6] = new TestSet("七日", "なのか");
        ts[7] = new TestSet("八日", "ようか");
        ts[8] = new TestSet("九日", "ここのか");
        ts[9] = new TestSet("十日", "とおか");
        //shuffle array 
        Random r = new Random();
        for (int i = 0; i < ts.length; i++) {
            int idx = r.nextInt(ts.length);
            TestSet temp = ts[i];
            ts[i] = ts[idx];
            ts[idx] = temp;
        }
        return ts;
    }

    public static TestSet[] getAllTestSetFromDB() {
        String sql = "select * from date";
        return DBConnection.query(sql);
    }
}

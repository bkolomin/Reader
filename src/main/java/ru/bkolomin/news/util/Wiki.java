package ru.bkolomin.news.util;

import java.sql.*;

public class Wiki {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://***/my_wiki";

    //  Database credentials
    static final String USER = "remote_user";
    static final String PASS = "some_pass123";


    public static String getText(int pageId){

        String text = "";

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "select page.page_id, page.page_title, text.old_text from page left join text on text.old_id = page.page_latest where page_id = " + pageId + ";";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                text = rs.getString("old_text");
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return text;

    }
}

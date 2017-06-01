package com.company;
import java.sql.*;


public class Main {  //<--- class deffinition

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "/Users/sami/Desktop/TestDB/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contact";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "EMAIL";






    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);

            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS" + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS" + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + "text, " +
                    COLUMN_PHONE + "integer, " +
                    COLUMN_EMAIL + "text," +
                    "(");

            statement.execute("INSERT INTO " +TABLE_CONTACTS+ "(" + COLUMN_NAME)

            ResultSet results = statement.executeQuery("select * from contact");
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                                results.getInt("phone") + " " +
                                results.getString("email"));
            }

            results.close();






            statement.close();
            conn.close();

//            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");
//            Class.forName("org.sql.JDBC");

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}

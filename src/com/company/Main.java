package com.company;
import java.sql.*;


public class Main {

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/Production/Courses/Programs/JavaPrograms/TestDB/testjava.db");
//            Statement statement = conn.createStatement()) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:testjava.db");
            //conn.setAutoCommit(false);

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE  if not exists contact" +
                    " (name TEXT, phone INTEGER, email TEXT)");
//
//            statement.execute("insert into contact (name, phone, email) " +
//                    "values('sami', 898989, 'sami@email.com')");
//
//            statement.execute("insert into contact (name, phone, email) " +
//                    "values('johnny', 1020293, 'appleseed@email.com')");

            statement.execute("update contact set phone=2222 where name = 'jane'");

//            statement.execute("delete from contact where name = 'jane'");


            statement.execute("select * from contact");
            ResultSet results = statement.getResultSet();
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

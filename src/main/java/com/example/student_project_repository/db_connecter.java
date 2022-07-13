package com.example.student_project_repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class db_connecter {
    private static String fetchedpassword = "";

    public static String getFetchedpassword() {
        return fetchedpassword;
    }


    public static String getconnection(int studentsId) throws Exception {
       try {
           String Driver = "com.mysql.cj.jdbc.Driver";
           String url = "jdbc:mysql://localhost:3306/studentaccount";
           String dbUsername = "root";
           String dbPassword = "";
           Class.forName(Driver);

           Connection con = DriverManager.getConnection(url, dbUsername, dbPassword );
           Statement statement = con.createStatement();
           String query = String.format("SELECT `password` from `studentprojects` WHERE `studId` = %d ", studentsId);
           ResultSet resultSet = statement.executeQuery(query);
           while(resultSet.next()){
               fetchedpassword = resultSet.getString("password");
           }
           statement.close();
       } catch (Exception e) {
           System.out.println(e);
       }
       return null;
   }
    public static void main(String[] args) throws Exception {
        //main function

    }
}

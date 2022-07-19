package com.example.student_project_repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class db_connecter {
    private static String fetchedpassword = "";
    private static String fetchedfirstName = "";
    private static String fetchedlastName = "";
    private static float fetchedBalance = 0;
    private static int fetchedStudentID = 0;
    private static  int fetchedprojectNum = 0;
    public String[] projectTitle = new String[10];
    public String[] projectDesc = new String[10];
    public String[] projectPrice = new String[10];
    public String[] projectStatus = new String[10];
    public String[] projectOwnerFirstName = new String[10];
    public String[] imagePath = new String[10];

    public static int getFetchedprojectNum() {
        return fetchedprojectNum;
    }

    public static int getFetchedStudentID() {
        return fetchedStudentID;
    }

    public static float getFetchedBalance() {
        return fetchedBalance;
    }
    public static String getFetchedfirstName() {
        return fetchedfirstName;
    }
    public static String getFetchedlastName() {
        return fetchedlastName;
    }
    public static String getFetchedpassword() {
        return fetchedpassword;
    }
    static String Driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/studentaccount";
    static String dbUsername = "root";
    static String dbPassword = "";
    public void addProject(String projTitle,String ProjCata, String projDesc, String projPrice, String projStatus, String ImgPath, int StudID) throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
         String query = "INSERT INTO `projectlist` (`projectTitle`, `projectCatagory`,`projectDesc`, `projectPrice`, `projectStatus`," +
                 " `imagePath`, `studId`) VALUES (?, ?, ?, ?, ?, ?, ?);";
         PreparedStatement statement = con.prepareStatement(query);
         statement.setString(1, projTitle);
         statement.setString(2, ProjCata);
        statement.setString(3, projDesc);
        statement.setString(4, projPrice);
        statement.setString(5, projStatus);
        statement.setString(6, ImgPath);
        statement.setString(7, String.valueOf(StudID));
        statement.executeUpdate();
        statement.close();;
    }
    public void getProjectList() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
        String query = "SELECT projectlist.projectTitle, projectlist.projectDesc, projectlist.projectPrice,studentprojects.firstName, " +
                "projectlist.projectStatus, projectlist.imagePath FROM projectlist " +
                "INNER JOIN studentprojects ON projectlist.studId = studentprojects.studId";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        int i=0;
        while(result.next()){
            projectTitle[i] = result.getString("projectTitle");
            projectDesc[i] = result.getString("projectDesc");
            projectPrice[i] = result.getString("projectPrice");
            projectStatus[i] = result.getString("projectStatus");
            imagePath[i] = result.getString("imagePath");
            projectOwnerFirstName[i] = result.getString("firstName");
            i++;
        }
        statement.close();
        }
    public static void getupdatePassword(int studentsId, String Password)throws Exception {
            Class.forName(Driver);
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword );
            String query = "update studentprojects set password = ? where studId = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (1, Password);
            preparedStmt.setInt(2, studentsId);

            preparedStmt.executeUpdate();

            con.close();


    }
    public static void withdrawMoney(float balance, int StudentID)throws Exception{
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
        String query = "update studentprojects set Balance = ? where studId = ?";
        PreparedStatement prepared = con.prepareStatement(query);
        prepared.setFloat(1, balance);
        prepared.setInt(2, StudentID);
        prepared.executeUpdate();
        con.close();
    }
    public static void getconnection(int studentsId) throws Exception {
       try {
           Class.forName(Driver);
           Connection con = DriverManager.getConnection(url, dbUsername, dbPassword );
           Statement statement = con.createStatement();
           String query = String.format("SELECT * from `studentprojects` WHERE `studId` = %d ", studentsId);
           ResultSet resultSet = statement.executeQuery(query);
           while(resultSet.next()){
               fetchedpassword = resultSet.getString("password");
               fetchedfirstName = resultSet.getString("firstName");
               fetchedBalance = resultSet.getFloat("Balance");
               fetchedStudentID = resultSet.getInt("studId");
               fetchedlastName = resultSet.getString("lastName");
               fetchedprojectNum = Integer.parseInt(resultSet.getString("projectNumbers"));
           }
           statement.close();
       } catch (Exception e) {
           throw(e);

       }
   }

}

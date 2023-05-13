package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends Config{
    Connection dbconn;
    public Connection getDBconn() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbconn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbconn;
    }
    public void getDB() throws SQLException, ClassNotFoundException {
        String out = "SELECT * FROM " + Const.USER_TABLE;
        PreparedStatement prSt = dbconn.prepareStatement(out);
        ResultSet resultSet = prSt.executeQuery();
        List<Persons> list = new ArrayList<>();
        while(resultSet.next()){
            Integer id = resultSet.getInt(1);
            String person_name = resultSet.getString(2);
            Integer salary = resultSet.getInt(3);
            list.add(new Persons(id, person_name, salary));
        }
        prSt.close();
        System.out.println(list);
    }
    public void InsertIntoDB(int id, String Name, Integer salary){
        String insertInto = "INSERT INTO " + Const.USER_TABLE + "("+ Const.USER_ID + ", " + Const.USER_NAME+ ", " + Const.USER_SALARY + ") VALUES(?, ?, ?);";
        try {
            PreparedStatement prST = dbconn.prepareStatement(insertInto);
            prST.setInt(1, id);
            prST.setString(2, Name);
            prST.setInt(3, salary);
            prST.execute();
            prST.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}

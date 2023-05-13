package org.example;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

        DBHandler db = new DBHandler();
        System.out.println(db.getDBconn());
        db.InsertIntoDB(3, "user2", 3000);
        db.getDB();
    }
}

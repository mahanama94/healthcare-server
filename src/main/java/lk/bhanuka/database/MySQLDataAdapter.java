package lk.bhanuka.database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by bhanuka on 12/10/16.
 */
public class MySQLDataAdapter implements DataAdapter {

    private String databaseName = "databaseProject";
    private String username = "databaseProject";
    private String hostName = "localhost";
    private String password = "P@ssword123";
    private int portNumber = 3306;
    private Connection databaseConnection;

    public MySQLDataAdapter(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            this.databaseConnection = DriverManager.getConnection("jdbc:mysql://"+this.hostName+"/"+this.databaseName , this.username, this.password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String query) {
        try {
            Statement statement = this.databaseConnection.createStatement();

            return statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public ResultSet action(String action, String table, ArrayList<String> conditions) {

        String processedConsitions = "";

        for (String condition :conditions) {
            processedConsitions = processedConsitions + " AND ";
        }

        processedConsitions = processedConsitions + " '1' = '1' ";

        return this.query(action+" From "+table+" where "+ processedConsitions);
    }

}

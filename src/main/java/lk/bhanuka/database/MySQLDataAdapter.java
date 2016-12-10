package lk.bhanuka.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List query(String query) {
        try {
            Statement statement = this.databaseConnection.createStatement();

            return this.resultsToList(statement.executeQuery(query));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public List action(String action, String table, ArrayList<String> conditions) {

        String processedConditions = "";

        for (String condition :conditions) {
            processedConditions = processedConditions + " AND ";
        }

        processedConditions = processedConditions + " '1' = '1' ";

        return this.query(action+" From "+table+" where "+ processedConditions);
    }

    public List get(String table, ArrayList<String> conditions) {

        return this.action(" select * ", table, conditions);

    }

    public boolean insert(String table, HashMap values) {
        return false;
    }

    private List resultsToList(ResultSet results) throws SQLException{

        ResultSetMetaData md = results.getMetaData();

        int columns = md.getColumnCount();

        ArrayList list = new ArrayList(50);

        while (results.next()){
            HashMap row = new HashMap(columns);
            for(int i=1; i<=columns; ++i){
                row.put(md.getColumnName(i),results.getObject(i));
            }
            list.add(row);
        }

        return list;
    }

}

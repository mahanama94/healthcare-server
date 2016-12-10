package lk.bhanuka.database;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by bhanuka on 12/10/16.
 */
public class DataService implements DataAdapter{

    private DataAdapter dataAdapter;

    public DataService(){
        this.dataAdapter = new MySQLDataAdapter();
    };

    public ResultSet query(String query) {
        return this.dataAdapter.query(query);
    }

    public ResultSet action(String action, String table, ArrayList<String> conditions) {
        return this.dataAdapter.action(action, table, conditions);
    }

}

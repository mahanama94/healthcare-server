package lk.bhanuka.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
public class DataService implements DataAdapter{

    private DataAdapter dataAdapter;

    public DataService(){
        this.dataAdapter = new MySQLDataAdapter();
    }

    public List<HashMap> query(String query) {
        return this.dataAdapter.query(query);
    }

    public List<HashMap> action(String action, String table, ArrayList<String> conditions) {
        return this.dataAdapter.action(action, table, conditions);
    }

    public List<HashMap> get(String table, ArrayList<String> conditions) {

        return this.dataAdapter.get(table, conditions);

    }

    public HashMap insert(String table, HashMap values) {
        return this.dataAdapter.insert(table, values);
    }

    public HashMap update(String table, HashMap values, ArrayList<String> conditions){
        return this.dataAdapter.update(table, values, conditions);
    }

}

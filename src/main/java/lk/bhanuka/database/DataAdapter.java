package lk.bhanuka.database;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by bhanuka on 12/10/16.
 */
public interface DataAdapter {

    public ResultSet query(String query);

    public ResultSet action(String action, String table, ArrayList<String> conditions);

    public ResultSet get(String table, ArrayList<String> conditions);

}

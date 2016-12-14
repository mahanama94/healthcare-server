package lk.bhanuka.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
public interface DataAdapter {

    public List<HashMap> query(String query);

    public List<HashMap> action(String action, String table, ArrayList<String> conditions);

    public List<HashMap> get(String table, ArrayList<String> conditions);

    public HashMap update(String table, HashMap vlues, ArrayList<String> conditions);

    public HashMap insert(String table, HashMap values);

}

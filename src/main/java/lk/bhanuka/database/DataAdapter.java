package lk.bhanuka.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
public interface DataAdapter {

    List<HashMap> query(String query);

    List<HashMap> action(String action, String table, ArrayList<String> conditions);

    List<HashMap> get(String table, ArrayList<String> conditions);

    HashMap update(String table, HashMap values, ArrayList<String> conditions);

    HashMap insert(String table, HashMap values);

}

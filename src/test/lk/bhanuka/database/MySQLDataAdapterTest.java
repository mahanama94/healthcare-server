package lk.bhanuka.database;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by bhanuka on 12/14/16.
 */
public class MySQLDataAdapterTest {

    private MySQLDataAdapter mySQLDataAdapter= new MySQLDataAdapter();

    @Test
    public void query() throws Exception {

    }

    @Test
    public void action() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void update() throws Exception {
        HashMap values = new HashMap();

        values.put("id", 1);
        values.put("name", "bhanuka");

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(" name = 'test'");

        this.mySQLDataAdapter.update("test", values, conditions);
    }

    @Test
    public void insert() throws Exception {

    }

}
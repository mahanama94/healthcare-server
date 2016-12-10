package lk.bhanuka.database;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by bhanuka on 12/10/16.
 */
public class MySQLDataAdapterTest extends TestCase {

    @Autowired
    DataAdapter mySQLDataAdapter = new MySQLDataAdapter();

    @Test
    public void query() throws Exception {
        Assert.assertNotEquals(null, this.mySQLDataAdapter.query(" show tables "));
    }

    @Test
    public void action() throws Exception {

    }

}
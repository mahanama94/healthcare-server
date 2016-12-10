package lk.bhanuka.DAO;

import lk.bhanuka.database.DataService;

/**
 * Created by bhanuka on 12/10/16.
 */
public abstract class DAO {

    protected DataService dataService;

    public DAO(){
        this.dataService = new DataService();
    }
}

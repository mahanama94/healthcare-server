package lk.bhanuka.DAO;

import lk.bhanuka.models.Province;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/15/16.
 */
public class ProvinceDAO extends DAO{

    private String provinceName = "province_name";

    public ProvinceDAO(){
        this.tableName = "province";
        this.primaryKey = "province_id";
    }

    public Province getProvince(Long id){

        ArrayList<String> conditions = new ArrayList<>();

        conditions.add(this.primaryKey + " = " + id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for (HashMap element: results){

            return this.createProvince(element);

        }

        return null;
    }

    private Province createProvince(HashMap element){

        return new Province(Long.valueOf(element.get(this.primaryKey).toString()), element.get(this.provinceName).toString());
    }
}

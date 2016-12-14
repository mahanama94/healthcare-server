package lk.bhanuka.DAO;

import lk.bhanuka.models.District;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/15/16.
 */
public class DistrictDAO extends DAO {

    private String districtName = "district_name";

    public DistrictDAO(){
        this.tableName = "district";
        this.primaryKey = "district_id";
    }

    public District getDistrict(Long id){

        ArrayList<String> conditions = new ArrayList<>();

        conditions.add(this.primaryKey + " = " + id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for (HashMap element: results){

            return this.createDistrict(element);

        }

        return null;
    }

    private District createDistrict(HashMap element){

        return new District(Long.valueOf(element.get(this.primaryKey).toString()), element.get(this.districtName).toString());
    }
}

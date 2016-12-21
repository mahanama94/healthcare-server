package lk.bhanuka.DAO;

import lk.bhanuka.authentication.Auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/21/16.
 */
public class HomeDAO extends DAO{

    public List getHomeContent(){

        HashMap response = new HashMap();

        ArrayList<String> conditions = new ArrayList<>();
        conditions.add("disease.disease_id = district_disease.disease_id");
        conditions.add("district_disease.district_id = "+ Auth.getUser().getDistrict_id());

        List<HashMap> results = this.dataService.get("disease, district_disease", conditions);

        return results;
    }


}

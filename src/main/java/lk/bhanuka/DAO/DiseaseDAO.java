package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;
import lk.bhanuka.models.MedicalOfficer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/9/16.
 */
public class DiseaseDAO extends DAO{

    public DiseaseDAO(){
        super();
        this.tableName = "disease";
    }

    public List<Disease> diseaseList(){

        return  this.findDiseases(new ArrayList());

    }

    public Disease getDisease(long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(" id = "+ Long.toString(id));

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results) {

            return new Disease(Long.valueOf(element.get("id").toString()), element.get("name").toString());

        }

        return null;

    }

    public List<Disease> findDiseases(ArrayList conditions){

        ArrayList<Disease> diseases = new ArrayList<Disease>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results) {

            Disease disease = new Disease(Long.valueOf(element.get("id").toString()), element.get("name").toString());

            diseases.add(disease);

        }

        return diseases;

    }

    public Disease addDisease(Disease disease){

        // Perform database operations with this.dataservice

        return disease;

    }

}

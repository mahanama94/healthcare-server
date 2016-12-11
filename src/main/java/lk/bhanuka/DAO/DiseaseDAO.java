package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;
import lk.bhanuka.models.MedicalOfficer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/9/16.
 */
@Component
public class DiseaseDAO extends DAO{

    private ArrayList<Disease> diseases;

    public DiseaseDAO(){
        super();
        this.tableName = "disease";
        this.primaryKey = "id";

    }

    public List<Disease> diseaseList(){

        return  this.findDiseases(new ArrayList());

    }

    public Disease getDisease(long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(this.primaryKey + " = "+ Long.toString(id));

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        if( results != null) {


            for (HashMap element : results) {

                return new Disease(Long.valueOf(element.get(this.primaryKey).toString()), element.get("name").toString());

            }

        }

        return null;

    }

    public List<Disease> findDiseases(ArrayList conditions){

        ArrayList<Disease> diseases = new ArrayList<Disease>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results) {

            Disease disease = new Disease(Long.valueOf(element.get(this.primaryKey).toString()), element.get("name").toString());

            diseases.add(disease);

        }

        return diseases;

    }

    public Disease addDisease(Disease disease){

        // Perform database operations with this.dataservice

        return disease;

    }

}

package lk.bhanuka.DAO;

import lk.bhanuka.models.MedicalOfficer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
public class MedicalOfficerDAO extends DAO{

    public MedicalOfficerDAO(){
        super();
        this.tableName = "medicalOfficer";
    }

    public List<MedicalOfficer> getMedicalOfficers(){

        return this.findMedicalOfficers(new ArrayList());

    }

    public MedicalOfficer getMedicalOfficer(Long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add( " id = "+ id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions );

        for(HashMap element : results) {

            MedicalOfficer medicalOfficer = new MedicalOfficer(Long.valueOf(element.get("id").toString()), element.get("name").toString());

            return medicalOfficer;

        }

        return  null;

    }

    public List<MedicalOfficer> findMedicalOfficers(ArrayList conditions){

        ArrayList<MedicalOfficer> medicalOfficers = new ArrayList<MedicalOfficer>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results) {

            MedicalOfficer medicalOfficer = new MedicalOfficer(Long.valueOf(element.get("id").toString()), element.get("name").toString());

            medicalOfficers.add(medicalOfficer);

        }

        return medicalOfficers;
    }

    public MedicalOfficer addMedicalOfficer(MedicalOfficer medicalOfficer){

        // Perform database operations with this.dataservice

        return null;

    }
}

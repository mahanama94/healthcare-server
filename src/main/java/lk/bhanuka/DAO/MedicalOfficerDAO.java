package lk.bhanuka.DAO;

import lk.bhanuka.models.MedicalOfficer;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
public class MedicalOfficerDAO extends DAO{

    private String nic = "nic";

    private String name = "NAME";

    private String dob = "dob";

    private String specialization = "specialization";

    private String district = "district_id";

    public MedicalOfficerDAO(){
        super();
        this.tableName = "medical_officer";
        this.primaryKey = this.nic;
    }

    public List<MedicalOfficer> getMedicalOfficers(){

        return this.findMedicalOfficers(new ArrayList());

    }

    public MedicalOfficer getMedicalOfficer(String nic){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add( this.primaryKey+"  = '"+ nic+"'");

        List<HashMap> results = this.dataService.get(this.tableName, conditions );

        for(HashMap element : results) {

            MedicalOfficer medicalOfficer = this.createMedicalOfficer(element);

            return medicalOfficer;

        }

        return  null;

    }

    public MedicalOfficer getMedicalOfficer(Long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add( this.primaryKey+"  = "+ id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions );

        for(HashMap element : results) {

            MedicalOfficer medicalOfficer = this.createMedicalOfficer(element);

            return medicalOfficer;

        }

        return  null;

    }

    public List<MedicalOfficer> findMedicalOfficers(ArrayList conditions){

        ArrayList<MedicalOfficer> medicalOfficers = new ArrayList<MedicalOfficer>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results) {

            MedicalOfficer medicalOfficer = this.createMedicalOfficer(element);

            medicalOfficers.add(medicalOfficer);

        }

        return medicalOfficers;
    }

    // TODO - implement add to database
    public MedicalOfficer addMedicalOfficer(MedicalOfficer medicalOfficer){

        // Perform database operations with this.dataservice

        return null;

    }

    public HashMap addMedcicalOfficer(HashMap credentials){

        HashMap values = new HashMap();

        values.put(nic, credentials.get("nic").toString());
        values.put(name, credentials.get("name"));
        values.put(dob, credentials.get("dob"));
        values.put("pwd" , BCrypt.hashpw(credentials.get("password").toString(), BCrypt.gensalt()));
        values.put(this.district, credentials.get("district_id"));
        values.put("role", "medical_officer");
        values.put(this.specialization,credentials.get("specialization"));
        System.out.println(credentials.toString());
        System.out.println("values : " + values.toString());
        HashMap response = this.dataService.insert(this.tableName, values);

        HashMap results = new HashMap();

        if(response.get("error") == null ){

            results.put("medicalOfficer", this.getMedicalOfficer(credentials.get("nic").toString()));

        }
        else{

            results.put("error", response.get("error"));

        }

        System.out.println(results.toString());
        return results;

    }

    private MedicalOfficer createMedicalOfficer(HashMap element){
        System.out.println(element.toString());
        MedicalOfficer medicalOfficer = new MedicalOfficer(
                element.get(this.nic).toString(),
                element.get(this.name).toString(),
                element.get(this.dob).toString()
        );

        if(element.get(this.specialization) != null){
            medicalOfficer.setSpecialization(element.get(this.specialization).toString());
        }
        else{
            medicalOfficer.setSpecialization("general");
        }

        if (element.get("district_id") != null){
            medicalOfficer.setDistrict_id(Long.parseLong(element.get("district_id").toString()));
        }

        return medicalOfficer;

    }
}

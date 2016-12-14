package lk.bhanuka.DAO;

import lk.bhanuka.models.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/11/16.
 */
public class PatientDAO extends DAO{

    private String name;

    private String dob;

    public PatientDAO(){
        super();
        this.tableName = " patient ";
        this.primaryKey = "patient_id";
        this.name = "NAME";
        this.dob = "dob";
    }

    public List<Patient> getPatients(){
        return this.findPatients(new ArrayList<String>());
    }

    public Patient getPatient(Long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(this.primaryKey+ " = "+ id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions);
        
        System.out.println(results);

        for(HashMap element : results){

            Patient patient = this.createPatient(element);

            return patient;

        }

        return null;
    }

    public List<Patient> findPatients(ArrayList<String> conditions){

        ArrayList<Patient> patients = new ArrayList<Patient>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            Patient patient = this.createPatient(element);

            patients.add(patient);

        }

        return patients;

    }

    public HashMap addPatient(Patient patient){

        HashMap values = new HashMap();

        values.put(this.name, patient.getName());
        values.put(this.dob, patient.getDateOfBirth());

        HashMap response = this.dataService.insert(this.tableName, values);

        HashMap results = new HashMap();

        if(response.get("error") == null){

            response.put(this.primaryKey, response.get("GENERATED_KEY"));

            results.put("patient", this.createPatient(response));

        }
        else{

            results.put("error", response.get("error"));
        }

        return results;

    }

    private Patient createPatient(HashMap element){

        return new Patient(Long.valueOf(element.get(this.primaryKey).toString()), 
        								element.get("NAME").toString(),
        								element.get("nic").toString(),
        								
        								);

    }



}

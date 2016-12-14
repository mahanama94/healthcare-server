package lk.bhanuka.DAO;

import lk.bhanuka.models.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/11/16
 */
public class PatientDAO extends DAO{

	private String nic;
	
	private String name;

    private String dob;
    
    private String district_id;
   

    public PatientDAO(){
        super();
        this.tableName = " patient ";
        this.primaryKey = "patient_id";
        
        this.nic = "nic";
        this.name = "NAME";
        this.dob = "dob";
        this.district_id = "district_id";
    }

    public List<Patient> getPatients(){
        return this.findPatients(new ArrayList<String>());
    }

    public Patient getPatient(Long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(this.primaryKey+ " = "+ id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            Patient patient = this.createPatient(element);

            return patient;
        }
        return null;
    }

    public List<Patient> findPatients(ArrayList<String> conditions){

        ArrayList<Patient> patients = new ArrayList<Patient>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);
        
        //System.out.println(results);

        for(HashMap element : results){
        	
        	//System.out.println(element.get("nic"));

            Patient patient = this.createPatient(element);

            patients.add(patient);

        }

        return patients;

    }

    public HashMap addPatient(Patient patient){

        HashMap values = new HashMap();
        
        values.put(nic, patient.getNic());
        values.put(name, patient.getName());
        values.put(dob, patient.getDateOfBirth());
        values.put(district_id, patient.getDistrict_id());

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
    

    private Patient createPatient(@SuppressWarnings("rawtypes") HashMap element){

        Patient new_patient =  new Patient(Long.valueOf(element.get(this.primaryKey).toString()), 
        								element.get(nic).toString(),
        								element.get(name).toString(),
        								element.get(dob).toString(),
										Long.valueOf(element.get(district_id).toString()));

		return new_patient;
     }



}
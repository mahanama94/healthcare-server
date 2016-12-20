package lk.bhanuka.DAO;

import lk.bhanuka.models.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/11/16
 */
public class PatientDAO extends DAO{

	private String nic = "nic";
	
	private String name = "NAME";

    private String dob = "dob";
    
    private String district_id = "district_id";

    public PatientDAO(){
        super();
        this.tableName = " patient ";
        this.primaryKey = this.nic;
    }

    public List<Patient> getPatients(){
        return this.findPatients(new ArrayList<String>());
    }

    public Patient getPatient(String nic){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(this.primaryKey+ " = '"+ nic+"'");

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            Patient patient = this.createPatient(element);

            return patient;
        }
        return null;

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

    public HashMap addPatient(HashMap patientData){
        HashMap values = new HashMap();

        values.put(nic, patientData.get("nic").toString());
        values.put(name, patientData.get("name"));
        values.put(dob, patientData.get("dob"));
        values.put("pwd" ,patientData.get("password"));
        values.put(district_id,patientData.get("district_id"));
        values.put("role", patientData.get("role"));

        HashMap response = this.dataService.insert(this.tableName, values);

        HashMap results = new HashMap();

        if(response.get("error") == null){

            //System.out.println("NIC : "+ patientData.get("nic").toString());

            results.put("patient", this.getPatient(patientData.get("nic").toString()));

        }else{
            results.put("error", response.get("error"));
        }

        //System.out.println(results.toString());
        return results;

    }
    public HashMap addPatient(Patient patient){

        HashMap values = new HashMap();
        
        values.put(nic, patient.getNic().toString());
        values.put(name, patient.getName());
        values.put(dob, patient.getDob());
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
    

    private Patient createPatient(HashMap element){

        Patient new_patient =  new Patient(
                element.get(this.nic).toString(),
                element.get(this.name).toString(),
                element.get(this.dob).toString(),
                Long.parseLong(element.get(this.district_id).toString())
        );

		return new_patient;
     }



}
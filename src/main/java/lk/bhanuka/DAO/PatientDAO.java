package lk.bhanuka.DAO;

import lk.bhanuka.models.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/11/16.
 */
public class PatientDAO extends DAO{

    public PatientDAO(){
        super();
        this.tableName = " report ";
    }

    public List<Patient> getPatients(){
        return this.findPatients(new ArrayList<String>());
    }

    public Patient getPatient(Long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(" id = "+ id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            Patient patient = new Patient(Long.valueOf(element.get("id").toString()), element.get("name").toString());

            return patient;

        }

        return null;
    }

    public List<Patient> findPatients(ArrayList<String> conditions){

        ArrayList<Patient> patients = new ArrayList<Patient>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            Patient patient = new Patient(Long.valueOf(element.get("id").toString()), element.get("name").toString());

            patients.add(patient);

        }

        return patients;

    }



}

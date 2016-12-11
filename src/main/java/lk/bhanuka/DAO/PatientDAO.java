package lk.bhanuka.DAO;

import lk.bhanuka.models.Patient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/11/16.
 */
public class PatientDAO extends DAO{

    public PatientDAO(){
        super();
        this.tableName = " patient ";
        this.primaryKey = "patient_id";
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

        for(HashMap element : results){

            Patient patient = this.createPatient(element);

            patients.add(patient);

        }

        return patients;

    }

    private Patient createPatient(HashMap element){

        return new Patient(Long.valueOf(element.get(this.primaryKey).toString()), element.get("NAME").toString());

    }



}

package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */

public class Patient extends User{
 
    public Patient(Long patient_id, String nic, String name, String dob, Long district_id){
    	id = patient_id;
    	this.nic = nic;
    	this.name = name;
    	this.dob = dob;
    	this.district_id = district_id;
    }

    public Patient(String nic, String name, String dob, Long district_id){
    	this.nic = nic;
    	this.name = name;
    	this.dob = dob;
    	this.district_id = district_id;
    }
    
    public String getRole() {return "patient";}

    public int getAccessLevel() {return 0;}
}

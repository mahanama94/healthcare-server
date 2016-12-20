package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/9/16.
 */

public class Patient extends User{
 
    public Patient(String nic, String name, String dob){

    	super(nic, name, dob);
    }

    public Patient(String nic, String name, String dob, long districtId){
        super(nic, name, dob);
        this.district_id = districtId;
    }

    public String getRole() {return "patient";}

    public int getAccessLevel() {return 0;}
}

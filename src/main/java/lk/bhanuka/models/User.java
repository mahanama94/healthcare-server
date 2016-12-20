package lk.bhanuka.models;

import java.util.ArrayList;

/**
 * Created by bhanuka on 12/11/16.
 */
public abstract class User {

    protected String nic;

    protected String name;

    protected String dob;

    protected Long district_id;
    
    protected Long province_id;

    protected ArrayList<Report> medicalReports;

    public User(String nic, String name, String dob){
        this.nic = nic;
        this.name = name;
        this.dob = dob;
    }

    // abstract methods \\
    public abstract int getAccessLevel();
    
    public abstract String getRole();
    
    // Basic getters and setters \\

	public String getNic() {return nic;}

	public void setNic(String nic) {this.nic = nic;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getDateOfBirth() {return dob;}

	public void setDateOfBirth(String dateOfBirth) {this.dob = dateOfBirth;}

	public Long getDistrict_id() {return district_id;}

	public void setDistrict_id(Long district_id) {this.district_id = district_id;}

	public Long getProvince_id() {return province_id;}

	public void setProvince_id(Long province_id) {this.province_id = province_id;}
    
   
    // Medical Reports handling \\ 
    
    //to add a list of medical reports \\
    public void addMedicalReports(ArrayList<Report> reports){ for(Report report: reports){ this.addMedicalReport(report);}}

   
    //to add a single report \\
    public void addMedicalReport(Report report){this.medicalReports.add(report);}

    
    public ArrayList<Report> getMedicalReports(){ return this.medicalReports; }}

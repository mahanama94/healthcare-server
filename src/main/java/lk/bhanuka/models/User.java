package lk.bhanuka.models;

import java.util.ArrayList;

/**
 * Created by bhanuka on 12/11/16.
 */
public abstract class User {

    protected Long id;

    protected String nic;

    protected String name;

    protected String dateOfBirth;

    protected Region region;

    protected ArrayList<Report> medicalReports;

    public User(Long id, String name){
        this.id = id;
        this.name = name;
        this.medicalReports = new ArrayList<Report>();
    }

    public abstract int getAccessLevel();

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth =dateOfBirth;
    }

    public void setDistrict(District district){
        this.region = district;
    }

    public void addMedicalReports(ArrayList<Report> reports){

        for(Report report: reports){

            this.addMedicalReport(report);

        }

    }

    public void addMedicalReport(Report report){

        this.medicalReports.add(report);

    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public abstract String getRole();

    public String getDateOfBirth(){ return this.dateOfBirth; }

    public District getDistrict(){ return (District)this.region; }

    public ArrayList<Report> getMedicalReports(){ return this.medicalReports; }
}

package lk.bhanuka.models;

/**
 * Created by bhanuka on 12/10/16.
 */
public class Report {

    private MedicalOfficer medicalOfficer;

    private String title;

    public Report(String title, MedicalOfficer medicalOfficer){
        this.title = title;
        this.medicalOfficer = medicalOfficer;
    }

    public MedicalOfficer getMedicalOfficer(){
        return this.medicalOfficer;
    }

    public String getTitle(){
        return this.title;
    }
}

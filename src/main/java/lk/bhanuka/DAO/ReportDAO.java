package lk.bhanuka.DAO;

import lk.bhanuka.models.MedicalOfficer;
import lk.bhanuka.models.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

/**
 * Created by bhanuka on 12/10/16.
 */
public class ReportDAO extends DAO {

    public ReportDAO(){
        super();
        PatientDAO patientDAO = new PatientDAO();
        this.tableName = "med_report";
        
    }

    public List<Report> getReports(){

        return this.findReports(new ArrayList<String>());

    }

    // TODO modify with new primary keys
//    public Report getReport(Long id){
//
//        ArrayList<String> conditions = new ArrayList<String>();
//
//        conditions.add(" id = "+ id.toString());
//
//        List<HashMap> results = this.dataService.get(this.tableName, conditions);
//
//        for(HashMap element : results){
//
//            MedicalOfficer medicalOfficer = (new MedicalOfficerDAO()).getMedicalOfficer(Long.valueOf(element.get("medicalOfficerId").toString()));
//
//            Report report = new Report(element.get("id").toString(), medicalOfficer);
//
//            return report;
//
//        }
//
//        return null;
//    }

    public List<Report> findReports(ArrayList<String> conditions){

        ArrayList<Report> reports = new ArrayList<Report>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);
        System.out.println(results);
        
        for(HashMap element : results){
        	
        	Report report = new Report(); 
        	report.setDisease_id((Long)element.get("disease_id"));
        	report.setMed_officer_nic((String)element.get("med_officer_nic"));
        	report.setPatient_nic((String)element.get("patient_nic"));
        	
        	
            

            reports.add(report);

        }

        return reports;
    }

    // TODO implement add method
    public Report addReport(Report report){

        // Perform database operations with this.dataService

        return report;

    }
    
}

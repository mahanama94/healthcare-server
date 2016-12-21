package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;
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
    
//    public Report getReport(String med_officer_nic, String patient_nic){
//    	ArrayList<String> conditions = new ArrayList<String>();
//    	
//    	conditions.add(" med_officer_nic " + med_officer_nic);
//    	conditions.add(" patient_nic " + patient_nic);
//    	
//    	
//    }

//     TODO modify with new primary keys
//    public ArrayList<E>Report getReport(ArrayList conditions){
//
//        //ArrayList<String> conditions = new ArrayList<String>();
//
//        //conditions.add(" id = "+ id.toString());
//
//        List<HashMap> results = this.dataService.get(this.tableName, conditions);
//
//        for(HashMap element : results){
//
//            //MedicalOfficer medicalOfficer = (new MedicalOfficerDAO()).getMedicalOfficer(Long.valueOf(element.get("medicalOfficerId").toString()));
//
//            
//        	
//        	//Report report = new Report(element.get("id").toString(), medicalOfficer);
//
//        	Report report = new Report();
//        	
//        	report.setLast_updated("last_updated");
//            report.setComments("comments");
//            report.setMed_officer_nic("med_officer_nic");
//            report.setMed_officer_name("med_officer_name");
//            report.setDisease_name("disease_name");
//            report.setPatient_nic("patient_nic");
//            report.setPatient_name("patient_name");
//            report.setPrescription("prescription");
//            report.setReport_date("report_date");
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
        	
        	//report.setReport_date((String)element.get("report_date"));
        	report.setPatient_nic((String)element.get("patient_nic"));
        	report.setMed_officer_nic((String)element.get("med_officer_nic"));
        	report.setDisease_id((Long)element.get("disease_id"));
        	report.setComments((String)element.get("comments"));
        	report.setPrescription((String)element.get("prescriptions"));
        	//report.setLast_updated((String)element.get("last_updated"));
        	
        	
            reports.add(report);

        }

        return reports;
    }

    // TODO implement add method
    public Report addReport(Report report){
    	
    	
        // Perform database operations with this.dataService
    	

        return report;

    }
    
    public HashMap updateReport(Report report){

		HashMap values = new HashMap();
		values.put("comments", report.getComments());
		values.put("prescriptions", report.getPrescription());
		values.put("last_updated_by", report.getLast_updated_by());

		ArrayList conditions = new ArrayList();
		conditions.add("patient_nic" + " = '"+ report.getPatient_nic() + "'");
		conditions.add("med_officer_nic" + " = '" + report.getMed_officer_nic() + "'");
		conditions.add("disease_id" + " = '" + report.getDisease_id() + "'");

		System.out.println("conditions ");
		System.out.println(conditions.toString());

		HashMap response = this.dataService.update(this.tableName, values, conditions);

		HashMap results = new HashMap();

		System.out.println(response.toString());

		if(response.get("error") == null){

//			response.put(this.primaryKey, disease.getId());
//			response.put(this.name, disease.getName());
			
			//results.put("disease", this.createDisease(response));
			return response;

		}

		else {

			results.put("error", response.get("error"));

		}

		return results;
	}
    
    
    
}

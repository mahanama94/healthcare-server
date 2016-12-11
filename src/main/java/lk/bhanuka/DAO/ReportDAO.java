package lk.bhanuka.DAO;

import lk.bhanuka.models.MedicalOfficer;
import lk.bhanuka.models.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
public class ReportDAO extends DAO {

    public ReportDAO(){
        super();
        this.tableName = "med_report";
    }

    public List<Report> getReports(){

        return this.findReports(new ArrayList<String>());

    }

    public Report getReport(Long id){

        ArrayList<String> conditions = new ArrayList<String>();

        conditions.add(" id = "+ id.toString());

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            MedicalOfficer medicalOfficer = (new MedicalOfficerDAO()).getMedicalOfficer(Long.valueOf(element.get("medicalOfficerId").toString()));

            Report report = new Report(element.get("id").toString(), medicalOfficer);

            return report;

        }

        return null;
    }

    public List<Report> findReports(ArrayList<String> conditions){

        ArrayList<Report> reports = new ArrayList<Report>();

        List<HashMap> results = this.dataService.get(this.tableName, conditions);

        for(HashMap element : results){

            MedicalOfficer medicalOfficer = (new MedicalOfficerDAO()).getMedicalOfficer(Long.valueOf(element.get("medicalOfficerId").toString()));

            Report report = new Report(element.get("id").toString(), medicalOfficer);

            reports.add(report);

        }

        return reports;
    }

    public Report addReport(Report report){

        // Perform database operations with this.dataService

        return report;

    }
}

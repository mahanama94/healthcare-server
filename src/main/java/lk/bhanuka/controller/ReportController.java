package lk.bhanuka.controller;

import lk.bhanuka.DAO.ReportDAO;
import lk.bhanuka.authentication.Auth;
import lk.bhanuka.models.Report;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class ReportController {

    private ReportDAO reportDAO;

    public ReportController(){

        this.reportDAO = new ReportDAO();

    }

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public List getReports(){
    	String role = Auth.getUser().getRole();
    	String nic = Auth.getUser().getNic();
    	System.out.println(role);
    	if (role == "patient"){
    		ArrayList conditions = new ArrayList();
    		//conditions.add("disease_name" + " LIKE '%"+ params.get("name") +"%'");
    		
    		conditions.add("patient_nic" + " = '" + nic + "'");
    		//return reportDAO.getReports()
    		return reportDAO.findReports(conditions);
    	}
    	else{
    		//System.out.println(role);
    		return null;
    	}
    	
        //return  this.reportDAO.getReports();
    	//return role;

    }

    @RequestMapping( value = "/reports/{patientId}/{medicalOfficerId}/{diseaseId}", method = RequestMethod.GET)
    public Report getReport(@PathVariable("patientId") Long patientId, @PathVariable("medicalOfficerId") Long medicalOfficerId, @PathVariable("diseaseId") Long diseaseId){

        System.out.println(patientId);

        System.out.println(medicalOfficerId);

        System.out.println(diseaseId);

        return null;

    }
}

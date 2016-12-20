package lk.bhanuka.controller;

import lk.bhanuka.DAO.PatientDAO;
import lk.bhanuka.models.Patient;
//import lk.bhanuka.validators.NewPatientValidator;
import lk.bhanuka.validators.Validator;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/11/16.
 */
@RestController
public class PatientController {


    private PatientDAO patientDAO;

    private Validator newValidator;

    public PatientController(){

        this.patientDAO = new PatientDAO();
        this.newValidator = new Validator();

    }

    @RequestMapping( value = "/patients", method = RequestMethod.GET)
    public List getPatients(){

        return  this.patientDAO.getPatients();

    }

    // TODO - implement search
    @RequestMapping( value = "/patients/search", method = RequestMethod.GET)
    public List findPatients(){

        return  this.patientDAO.findPatients(new ArrayList<String>());

    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") String nic){

        return  this.patientDAO.getPatient(nic);

    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public HashMap addPatient(HttpServletRequest request){
    	
    	ArrayList<String> required = new ArrayList<String>();

        required.add("nic");	required.add("name");
        required.add("dob");	required.add("district_id");

        HashMap validated = newValidator.validate(request, required);
        
        if (validated.get("error") == null) {
        	
        	Patient newPatient = new Patient(request.getParameter("nic"),
        								request.getParameter("name"),
        								request.getParameter("dob")
                                );
        						
        	
        	return patientDAO.addPatient(newPatient);
        }
        return validated;
        
    }
    
    // TODO: implement update
    @RequestMapping(value = "/patients", method = RequestMethod.PUT)
    public HashMap updatePatient(HttpServletRequest request){

        return null;
    }

}
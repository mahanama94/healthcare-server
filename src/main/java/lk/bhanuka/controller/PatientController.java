package lk.bhanuka.controller;

import lk.bhanuka.DAO.PatientDAO;
import lk.bhanuka.models.Patient;
import lk.bhanuka.validators.NewPatientValidator;
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

    private NewPatientValidator newPatientValidator;

    public PatientController(){

        this.patientDAO = new PatientDAO();
        this.newPatientValidator = new NewPatientValidator();

    }

    @RequestMapping( value = "/patients", method = RequestMethod.GET)
    public List getPatients(){

        return  this.patientDAO.getPatients();

    }

    @RequestMapping( value = "/patients/search", method = RequestMethod.GET)
    public List findPatients(){

        return  this.patientDAO.findPatients(new ArrayList<String>());

    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") Long id){

        return  this.patientDAO.getPatient(id);

    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public HashMap addPatient(HttpServletRequest request){

        HashMap validated = this.newPatientValidator.validate(request);

        if(validated.get("error") != null){
            return validated;
        }

        Patient newPatient = new Patient(Long.parseLong("1", 10), request.getParameter("name").toString());

        HashMap response = this.patientDAO.addPatient(newPatient);

        return response;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.PUT)
    public HashMap updatePatient(HttpServletRequest request){

        return null;
    }

}

package lk.bhanuka.controller;

import lk.bhanuka.DAO.PatientDAO;
import lk.bhanuka.models.Patient;
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

    public PatientController(){
        this.patientDAO = new PatientDAO();
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

        return null;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.PUT)
    public HashMap updatePatient(HttpServletRequest request){

        return null;
    }

}

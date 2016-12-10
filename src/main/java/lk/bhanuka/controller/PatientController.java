package lk.bhanuka.controller;

import lk.bhanuka.DAO.PatientDAO;
import lk.bhanuka.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bhanuka on 12/11/16.
 */
@RestController
public class PatientController {

    private PatientDAO patientDAO = new PatientDAO();

    @RequestMapping( value = "/patients", method = RequestMethod.GET)
    public List getPatients(){

        return  this.patientDAO.getPatients();

    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") Long id){

        return  this.patientDAO.getPatient(id);

    }



}

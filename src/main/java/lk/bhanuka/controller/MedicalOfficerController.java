package lk.bhanuka.controller;

import lk.bhanuka.DAO.MedicalOfficerDAO;
import lk.bhanuka.models.MedicalOfficer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class MedicalOfficerController {

    private MedicalOfficerDAO medicalOfficerDAO;

    public MedicalOfficerController(){
        this.medicalOfficerDAO = new MedicalOfficerDAO();
    }

    @RequestMapping(value = "/medicalofficers", method = RequestMethod.GET)
    public List getMedicalOfficers(){

        return this.medicalOfficerDAO.getMedicalOfficers();

    }

    @RequestMapping(value = "/medicalofficers/search", method = RequestMethod.GET)
    public List findMedicalOfficers(){

        return this.medicalOfficerDAO.findMedicalOfficers(new ArrayList());

    }

    @RequestMapping(value = "/medicalofficers/{id}", method = RequestMethod.GET)
    public MedicalOfficer getMedicalOfficer(@PathVariable("id") Long id){

        return this.medicalOfficerDAO.getMedicalOfficer(id);

    }
}

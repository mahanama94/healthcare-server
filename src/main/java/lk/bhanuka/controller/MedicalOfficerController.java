package lk.bhanuka.controller;

import lk.bhanuka.DAO.MedicalOfficerDAO;
import lk.bhanuka.models.MedicalOfficer;
import lk.bhanuka.validators.NewMedicalOfficerValidator;
import lk.bhanuka.validators.UpdateMedicalOfficerValidator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class MedicalOfficerController {

    private MedicalOfficerDAO medicalOfficerDAO;

    private NewMedicalOfficerValidator newMedicalOfficerValidator;

    private UpdateMedicalOfficerValidator updateMedicalOfficerValidator;

    public MedicalOfficerController(){

        this.medicalOfficerDAO = new MedicalOfficerDAO();

        this.newMedicalOfficerValidator = new NewMedicalOfficerValidator();

        this.updateMedicalOfficerValidator = new UpdateMedicalOfficerValidator();
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

    @RequestMapping(value = "/medicalofficers", method = RequestMethod.POST)
    public HashMap addMedicalOfficer(HttpServletRequest request){

        HashMap validated = this.newMedicalOfficerValidator.validate(request);

        if(validated.get("error") == null){
            validated.put("code" , "success");
        }

        return validated;

    }

    @RequestMapping(value = "/medicalofficers", method = RequestMethod.PUT)
    public HashMap updateMedicalOfficer(HttpServletRequest request){

        HashMap validated = this.updateMedicalOfficerValidator.validate(request);

        if(validated.get("error") == null){
            validated.put("code", "success");
        }

        return validated;
    }
}

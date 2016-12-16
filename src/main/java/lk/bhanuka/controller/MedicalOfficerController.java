package lk.bhanuka.controller;

import lk.bhanuka.DAO.MedicalOfficerDAO;
import lk.bhanuka.models.MedicalOfficer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/10/16.
 */
@RestController
public class MedicalOfficerController extends Controller{

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

    @RequestMapping(value = "/medicalofficers", method = RequestMethod.POST)
    public HashMap addMedicalOfficer(HttpServletRequest request){

        ArrayList<String> required = new ArrayList<>();

        required.add("name");

        HashMap validated = this.validate(request, required);

        if(validated.get("error") == null){
            validated.put("code" , "success");
        }

        return validated;

    }

    // TODO - implement update method
//    @RequestMapping(value = "/medicalofficers", method = RequestMethod.PUT)
//    public HashMap updateMedicalOfficer(HttpServletRequest request){
//
//        ArrayList<String> required = new ArrayList<>();
//
//        required.add("name");
//
//        HashMap validated = this.validate(request, request);
//
//        if(validated.get("error") == null){
//            validated.put("code", "success");
//        }
//
//        return validated;
//    }
}

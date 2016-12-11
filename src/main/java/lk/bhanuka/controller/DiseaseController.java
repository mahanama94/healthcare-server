package lk.bhanuka.controller;

import lk.bhanuka.DAO.DiseaseDAO;
import lk.bhanuka.models.Disease;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by bhanuka on 12/9/16.
 */
@RestController
public class DiseaseController {

    private DiseaseDAO diseaseDAO;

    public DiseaseController(){
        this.diseaseDAO = new DiseaseDAO();
    }

    @RequestMapping(value = "/diseases", method = RequestMethod.GET)
    public List getDiseases(){

        return this.diseaseDAO.diseaseList();

    }

    @RequestMapping(value = "/diseases/search", method = RequestMethod.GET)
    public List findDiseases(){

        return this.diseaseDAO.diseaseList();

    }

    @RequestMapping(value = "/diseases/{id}", method = RequestMethod.GET)
    public Disease getDisease(@PathVariable("id") Long id){

        return this.diseaseDAO.getDisease(id);

    }

    @RequestMapping(value="/diseases", method = RequestMethod.POST)
    public String getDisease(HttpServletRequest request, Model model){

        return request.getParameter("json");

    }

}

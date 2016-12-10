package lk.bhanuka.controller;

import lk.bhanuka.DAO.DiseaseDAO;
import lk.bhanuka.models.Disease;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bhanuka on 12/9/16.
 */
@RestController
public class DiseaseController {

    private DiseaseDAO diseaseDAO = new DiseaseDAO();

    @RequestMapping(value = "/diseases", method = RequestMethod.GET)
    public List getDiseases(){

        return this.diseaseDAO.diseaseList();

    }

    @RequestMapping(value = "/diseases/{id}", method = RequestMethod.GET)
    public Disease getDisease(@PathVariable("id") Long id){

        return this.diseaseDAO.getDisease(id);

    }

    @RequestMapping(value="/diseases", method = RequestMethod.POST)
    public Disease getDisease(@RequestBody Disease disease){

        Disease returnDisease = this.diseaseDAO.addDisease(disease);

        if(returnDisease != null){
            return returnDisease;
        }

        return null;
    }

}

package lk.bhanuka.controller;

import lk.bhanuka.DAO.HomeDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bhanuka on 12/21/16.
 */
@RestController
public class HomeController extends Controller {

    private HomeDAO homeDAO;

    public HomeController(){
        this.homeDAO = new HomeDAO();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List getHome(){
        HashMap results = new HashMap();

        results.put("diseases", this.homeDAO.getHomeContent());

        return this.homeDAO.getHomeContent();
//        return results;
    }

}

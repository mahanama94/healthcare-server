package lk.bhanuka.controller;

import lk.bhanuka.DAO.UserDAO;
import lk.bhanuka.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/15/16.
 */
@RestController
public class AuthController extends Controller {

    private UserDAO userDAO;

    public AuthController(){
        this.userDAO = new UserDAO();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HashMap login(HttpServletRequest request){

        ArrayList<String> required = new ArrayList<>();

        required.add("email");
        required.add("password");

        HashMap validated = validator.validate(request, required);

        if(validated.get("error") != null){
            return validated;
        }


        User user = this.userDAO.getUser(request.getParameter("email").toString(),
                request.getParameter( "password").toString());

        HashMap response = new HashMap();

        response.put("user", user);

//        response.put("request", request.getParameter());
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public HashMap signup(HttpServletRequest request){

        ArrayList<String> required = new ArrayList<>();

        required.add("email");
        required.add("password");

        HashMap validated = this.validator.validate(request, required);

        if(validated.get("error") != null){
            return  validated;
        }

        return  null;
    }
}

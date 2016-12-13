package lk.bhanuka.validators;

import lk.bhanuka.authentication.Auth;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/13/16.
 */
public class UpdatePatientValidator extends Validator{

    public UpdatePatientValidator(){

        this.required = new ArrayList<String>();

        this.required.add("id");

        this.accessLevel = 0;
    }


    protected HashMap authenticate(HttpServletRequest request){

        HashMap returnResponse = new HashMap();

        if(Auth.getUser().getId() != request.getAttribute("id")){

            returnResponse.put("error", "not authenticated");
        }

        return returnResponse;

    }

}

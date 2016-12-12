package lk.bhanuka.validators;

import lk.bhanuka.authentication.Auth;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/11/16.
 */
public abstract class Validator {

    /**
     * ArrayList of required field in the request
     */
    protected ArrayList<String> required;

    /**
     * Authentication level for a valid request - or more are valid
     */
    protected int accessLevel = 0;

    // TODO - move up the method - have a default implementation ( most of the time same happens)

    public abstract HashMap validate(HttpServletRequest request);

    public HashMap authenticate(){

        HashMap returnResponse = new HashMap();

//        if(Auth.getUser().getAccessLevel() >= this.accessLevel){
//
//            return returnResponse;
//
//        }
//
//        returnResponse.put("error", "not authenticated");

        return returnResponse;

    }

    protected HashMap checkRequired(HttpServletRequest request){

        HashMap returnResponse = new HashMap();

        for(String requirement : this.required){

            if((Boolean)(request.getParameter(requirement) == null)){

                returnResponse.put("error", requirement+" required");

                return returnResponse;
            }

        }

        return returnResponse;
    }

    protected HashMap convert(HttpServletRequest request){

        HashMap response = new HashMap();

        for(String requirement: this.required){

            response.put(requirement, request.getParameter(requirement));

        }

        return response;

    }
}

package lk.bhanuka.validators;

import lk.bhanuka.authentication.Auth;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/12/16.
 */
public class NewPatientValidator extends Validator {

    public HashMap validate(HttpServletRequest request) {

        HashMap returnResponse = this.checkRequired(request);

        if(returnResponse.get("error") !=null){

            return returnResponse;

        }

//        returnResponse = this.authenticate();
//
//        if(returnResponse.get("error") != null){
//
//            return returnResponse;
//
//        }

        return this.convert(request);
    }

    public HashMap authenticate(){

        HashMap returnResponse = new HashMap();

        if( Auth.getUser().getRole() == "medicalOfficer"){

            return returnResponse;

        }

        returnResponse.put("error", " permission denied " );

        return returnResponse;

    }

}

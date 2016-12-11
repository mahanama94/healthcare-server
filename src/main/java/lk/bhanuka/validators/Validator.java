package lk.bhanuka.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/11/16.
 */
public abstract class Validator {

    protected ArrayList<String> required;

    public abstract HashMap validate(HttpServletRequest request);

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
}

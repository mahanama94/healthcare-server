package lk.bhanuka.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/11/16.
 */
public class UpdateDiseaseValidator extends Validator {

    public UpdateDiseaseValidator(){

        this.required = new ArrayList<String>();
        this.required.add("id");
        this.required.add("name");
    }

    public HashMap validate(HttpServletRequest request) {

        HashMap returnResponse = this.checkRequired(request);

        if(returnResponse.get("error") !=null){
            return returnResponse;
        }

        return returnResponse;
    }

}

package lk.bhanuka.validators;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bhanuka on 12/11/16.
 */
public class NewDiseaseValidator extends Validator {

	public NewDiseaseValidator() {
		this.required = new ArrayList<String>();

		this.required.add("id");
		this.required.add("name");
		this.required.add("description");
		this.required.add("treatment");
	}
	
	public HashMap validate(HttpServletRequest request){

		HashMap returnResponse = this.checkRequired(request);

		System.out.println(returnResponse);

		if (returnResponse.get("error") != null) {
			return returnResponse;
		}
		return converter(request);
	}

	public HashMap converter(HttpServletRequest request){
		HashMap responce = new HashMap();
		for(String param: required){
			responce.put(param, request.getParameter(param));
			
		}
		return responce;
	}
	

}

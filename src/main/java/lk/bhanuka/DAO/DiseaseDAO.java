package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;

import java.util.ArrayList;

/**
 * Created by bhanuka on 12/9/16.
 */
public class DiseaseDAO {

    public ArrayList diseaseList(){
        ArrayList<Disease> returnList = new ArrayList<Disease>();

        for(int i =0; i < 6; i++){
            returnList.add(new Disease(i, "Some Name"));
        }

        System.out.println(returnList);

        return returnList;
    }

    public Disease getDisease(long id){
        return new Disease(id, "name");
    }

    public Disease addDisease(Disease disease){
        return disease;
    }

}

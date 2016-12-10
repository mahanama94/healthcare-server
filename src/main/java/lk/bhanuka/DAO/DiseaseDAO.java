package lk.bhanuka.DAO;

import lk.bhanuka.models.Disease;

import java.util.ArrayList;

/**
 * Created by bhanuka on 12/9/16.
 */
public class DiseaseDAO extends DAO{

    public ArrayList diseaseList(){
        // Perform database operations with this.dataservice

        ArrayList<Disease> returnList = new ArrayList<Disease>();

        for(int i =0; i < 6; i++){
            returnList.add(new Disease(i, "Some Name"));
        }

        System.out.println(returnList);

        return returnList;
    }

    public Disease getDisease(long id){

        // Perform database operations with this.dataservice

        return new Disease(id, "name");
    }

    public Disease addDisease(Disease disease){

        // Perform database operations with this.dataservice

        return disease;

    }

}

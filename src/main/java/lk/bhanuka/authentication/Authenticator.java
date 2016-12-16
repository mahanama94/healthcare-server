package lk.bhanuka.authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by bhanuka on 12/11/16.
 */
public class Authenticator {

    private ArrayList<String> guest;

    public Authenticator(){
        this.guest = new ArrayList<>();
        this.guest.add("/login");
        this.guest.add("/signup");
    }

    public boolean checkAuth(HttpServletRequest request){

        String path = request.getRequestURI().substring(request.getContextPath().length());

        if(this.guest.contains(path)){
            return true;
        }

        if(request.getParameter("token") == null){

            // TODO decrypt token and retrieve user and details

            return false;
        }

        return true;

    }

}

package lk.bhanuka.authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by bhanuka on 12/11/16.
 */
public class Authenticator {

    private ArrayList<String> guest;

    private TokenGenerator tokenGenerator;

    public Authenticator(){
        this.guest = new ArrayList<>();
        this.tokenGenerator = new TokenGenerator();
        this.guest.add("/login");
        this.guest.add("/signup");
    }

    public boolean checkAuth(HttpServletRequest request){

        String path = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println("request path : " + path);
        if(request.getParameter("data") != null) {
            System.out.println("data : "+ request.getParameter("data").toString());
        }
        if(this.guest.contains(path)){
            return true;
        }

        if(request.getParameter("token") == null){
            return false;
        }

        return true;
//        if(Auth.login(request.getParameter("token"))){
//            return true;
//        }
//        return false;

    }

}

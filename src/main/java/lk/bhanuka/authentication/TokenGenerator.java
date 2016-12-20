package lk.bhanuka.authentication;

import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer20010315ExclWithComments;
import io.jsonwebtoken.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by bhanuka on 12/18/16.
 */
public class TokenGenerator {

    public static String createToken(long id, String nic){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;

        JwtBuilder builder = null;
        try {
            builder = Jwts.builder().claim("id", id).claim("nic", nic)
                    .signWith(
                            SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return builder.compact();

    }

    public static String getNIC(String jwt){

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt);

            return claims.getBody().get("nic").toString();
        } catch (UnsupportedEncodingException e) {
            return null;
            //e.printStackTrace();
        }
        catch (Exception e){
            return null;
        }

    }

//    public static long getId(String jwt){
//
//        try {
//            Jws<Claims> claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt);
//
//            return Long.parseLong(claims.getBody().get("id").toString());
//
//        } catch (UnsupportedEncodingException e) {
//            //e.printStackTrace();
//            return -1;
//        }
//        catch (Exception e){
//            return -1;
//            //e.printStackTrace();
//        }
//
//    }

}

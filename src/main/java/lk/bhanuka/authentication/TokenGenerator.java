package lk.bhanuka.authentication;

import io.jsonwebtoken.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by bhanuka on 12/18/16.
 */
public class TokenGenerator {

    public static String createToken(long id, String email){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;

        JwtBuilder builder = null;
        try {
            builder = Jwts.builder().claim("id", id).claim("email", email)
                    .signWith(
                            SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return builder.compact();

    }

    public static String getEmail(String jwt){

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt);

            return claims.getBody().get("email").toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static long getId(String jwt){

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt);

            return Long.parseLong(claims.getBody().get("id").toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}

package tw.idv.hunterchen.lab.token;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.KeyPair;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        // load environment variables
        Dotenv dotenv = Dotenv.load();

        // JWT using HS256 Alg demo
        SignatureAlgorithm alg = SignatureAlgorithm.HS256 ;
            
        // expect jwt lifetime 2 hours
        Claims claims = Jwts.claims();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
        Date exp = calendar.getTime();
        claims.setExpiration(exp);

        // put userId to payload
        UUID uuid = UUID.randomUUID();
        String userId = uuid.toString();
        claims.put("userId", userId);

        // get secret key from environment
        String k = dotenv.get("HS256_KEY");
//        String k = "secretCanNotTellAnyOneAndAnyBody";
        Key secretKey = Keys.hmacShaKeyFor(k.getBytes());

        String token = Jwts.builder().setClaims(claims).signWith(alg, secretKey).compact();
        System.out.printf("JWT HS256 token: %s\n", token);

        // verify token
        try {
            Jws<Claims> data = Jwts.parser().require("userId", userId).setSigningKey(secretKey).parseClaimsJws(token);
            Claims info = data.getBody();
            // get userId from token
            System.out.printf("userId: %s\n", info.get("userId"));
        } catch (MalformedJwtException e) {
            System.out.printf("malformed token error: %s\n", e.getMessage());
        } catch (SignatureException e) {
            System.out.printf("secret key is not right error: %s\n", e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.printf("alg is not right error: %s\n", e.getMessage());
        } catch (MissingClaimException e) {
            System.out.printf("missing some claim field error: %s\n", e.getMessage());
        } catch (IncorrectClaimException e) {
            System.out.printf("claim field value is not right: %s\n", e.getMessage());
        }

        // JWT using RS256 Alg demo
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        token = Jwts.builder().claim("userId", userId).signWith(alg, keyPair.getPrivate()).compact();
        System.out.printf("JWT RSA256 token: %s\n", token);
        System.out.printf("userId: %s\n", Jwts.parser().setSigningKey(keyPair.getPublic()).parseClaimsJws(token).getBody().get("userId"));
    }
}


package tw.idv.hunterchen.lab.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class Token {
	//设置过期时间
    private static final long EXPIRE_DATE=30*60*100000;	// 30 分
    //token秘钥
    private static final String SECRET_KEY = "ZCEQIUBFKSJBFJH2020BQWE";
    
    //產生token
    public static String generateToken (String username,String password){
    	 
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            
            
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("password",password)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }
    //驗證token
    public static boolean verifyToken(String token){
        /**
         * @desc   验证token，通过返回true
         * @create 2019/1/18/018 9:39
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
    
    
    public static void main(String[] args) {
        String username ="zhangsan";
         String password = "123";
         String token = generateToken(username,password);
         System.out.println(token);
         boolean b = verifyToken(token);
         System.out.println(b);
     }
    
}
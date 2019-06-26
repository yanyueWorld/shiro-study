package token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Token工具类.
 *
 * @author yanyue, 2019/6/26
 * @version shiro v1.0
 */
public class TokenUtil {
    private static final String JWTSECRET="customJWT";
     /**
       * 创建Token
       * @param userId 用户id
       * @return String
       */
    public static String createToken(String userId){
        String token= Jwts.builder().setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis()+60*60*24*365))
                .signWith(SignatureAlgorithm.HS256, JWTSECRET)
                .compact();
        return token;
    }
     /**
       * 校验Token
       * @param token token
       * @return String
       */
    public static String verfiyToken(String token){
        String user=Jwts.parser().setSigningKey(JWTSECRET).parseClaimsJws(token).getBody().getSubject();
        return user;
    }
}

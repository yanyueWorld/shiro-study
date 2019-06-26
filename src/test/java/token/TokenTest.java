package token;

/**
 * Token 的使用.
 *
 * @author yanyue, 2019/6/26
 * @version token v1.0
 */
public class TokenTest {
    public static void main(String[] args) {
        String userId="1";
        String token=TokenUtil.createToken(userId);
        System.out.println(token);
        System.out.println(TokenUtil.verfiyToken(token));
    }
}

package hyxGit;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class GitHelloWorld {

	public static void main(String[] args) {
		System.out.println(explain());
		System.out.println(getPassword());
	}
	
	private static String explain(){
		return "This is my Git,hello World!";
	}
	
	private static String getPassword(){
        // 密码加密
        String encryptPwd = md5Hex("abcd+123456-e7");
		return encryptPwd;
	}

    /**
     * 获取十六进制字符串形式的MD5摘要 16位
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs)).substring(8, 24);
        } catch (Exception e) {
            return null;
        }
    }
}

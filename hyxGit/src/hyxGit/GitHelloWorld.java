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
        // �������
        String encryptPwd = md5Hex("abcd+123456-e7");
		return encryptPwd;
	}

    /**
     * ��ȡʮ�������ַ�����ʽ��MD5ժҪ 16λ
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

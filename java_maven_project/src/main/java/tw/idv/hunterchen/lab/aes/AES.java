package tw.idv.hunterchen.lab.aes;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import lombok.extern.slf4j.Slf4j;

/*
 * https://www.baeldung.com/java-aes-encryption-decryption
 */

@Slf4j
public class AES {

	public static void main(String[] args) {
		// 準備 明碼
		// 準備 密鑰
		// 使用密鑰加密明碼、產生暗碼
		String plainText="1234567890";
		String encodedText;
		SecretKey secretKey;
		try {
			secretKey = generateSecretKey(128);
		} catch (NoSuchAlgorithmException e) {
			log.error("產生SecreKeyg失敗!!!");
			e.printStackTrace();
		}
		
		
		
	}
	
	public static SecretKey generateSecretKey(int n) throws NoSuchAlgorithmException {
	   log.info("產生長度{}的SecreKey", n );
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    byte[] encodedKey = key.getEncoded();
	    
	    log.info("SecreKey={}", bytesToHexString(encodedKey));
	    log.info("SecreKey={}", key.getEncoded());
	    return key;
	}
	public static String bytesToHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }

	public static String encrypt(String algorithm
							   , String plainText
							   , SecretKey key
							   , IvParameterSpec iv) 
							   throws NoSuchPaddingException
							   		, NoSuchAlgorithmException
							   		, InvalidAlgorithmParameterException
							   		, InvalidKeyException
							   		, BadPaddingException
							   		, IllegalBlockSizeException {

	    Cipher cipher = Cipher.getInstance(algorithm);
	    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
	    byte[] cipherText = cipher.doFinal(plainText.getBytes());
	    return Base64.getEncoder()
	    			 .encodeToString(cipherText);
	}
}

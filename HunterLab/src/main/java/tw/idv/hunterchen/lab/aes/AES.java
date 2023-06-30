package tw.idv.hunterchen.lab.aes;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.utility.DevTool;

/*
 * https://www.baeldung.com/java-aes-encryption-decryption
 */

@Slf4j
public class AES {

	public static void main(String[] args) {
		String algorithm="AES/CBC/PKCS5Padding";				// 要採用的演算法
		String plainText="1234567890";							// 明文
		String password="qwert";
		SecretKey secretKey;									// 密鑰
		IvParameterSpec iv;
		String cipherText;										// 使用密鑰加密明碼、產生的密文
		String decryptedCipherText;								// 使用密鑰加密明碼、產生的密文
		String salt="salt";

		try {
			secretKey = generateSecretKey(256);
			secretKey = getSecretKeyFromPassword(password, salt);
			iv = generateIv();
			cipherText = encrypt(algorithm, plainText, secretKey, iv);
			decryptedCipherText=decrypt(algorithm, cipherText, secretKey, iv);
			log.info("plainText={}", plainText);
			log.info("cipherText={}", cipherText);
			log.info("decryptedCipherText={}",  decryptedCipherText);
		} catch (NoSuchAlgorithmException e) {
			log.error("產生SecreKeyg失敗!!!");
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			log.error("產生SecreKeyg失敗!!!");
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		}
	}
		
		
		
	// 產生 SecretKey 的方式.a
	public static SecretKey generateSecretKey(int length) throws NoSuchAlgorithmException {
		SecretKey key = null;
		if(length==128 || length==192 || length==256 ) {
			log.info("產生長度 {} 的SecreKey", length );
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(length);
			key = keyGenerator.generateKey();
			byte[] encodedKey = key.getEncoded();
			log.info("SecreKey={}", bytesToHexString(encodedKey));
			log.info("SecreKey={}", key.getEncoded());
			DevTool.showAllFields(key);
		}else {
			log.info("長度是 {}, 僅可以是 128、192、或256", length);			
		}
	    return key;
	}
	

	// 產生 SecretKey 的方式.b
	public static SecretKey getSecretKeyFromPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
	    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	    KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
	    SecretKey key = new SecretKeySpec(factory.generateSecret(keySpec).getEncoded(), "AES");
	    byte[] encodedKey = key.getEncoded();
	    log.info("SecreKey={}", bytesToHexString(encodedKey));
	    log.info("SecreKey={}", key.getEncoded());
	    DevTool.showAllFields(key);
	    return key;
	}
	
	public static IvParameterSpec generateIv() {
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    DevTool.showAllFields(iv);
	    return new IvParameterSpec(iv);
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
	public static String decrypt(String algorithm, String cipherText, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    byte[] plainText = cipher.doFinal(Base64.getDecoder()
		        .decode(cipherText));
		    return new String(plainText);
		}
}

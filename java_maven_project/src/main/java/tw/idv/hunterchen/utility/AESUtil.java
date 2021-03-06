package tw.idv.hunterchen.utility;

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

import org.apache.commons.codec.binary.Hex;

import lombok.extern.slf4j.Slf4j;
import tw.idv.hunterchen.utility.DevTool;

/*
 * https://www.baeldung.com/java-aes-encryption-decryption
 */

@Slf4j
public class AESUtil {
	private final static Integer DEFAULT_SEED=128;
	private static String salt="salt";
	private static String algorithm="AES/CBC/PKCS5Padding";				// 要採用的演算法
	private static IvParameterSpec iv = generateIv();
	private static SecretKey secretKey = generateSecretKey();									// 密鑰
	
	 // 產生 SecretKey 的方式.a
	public static SecretKey generateSecretKey() {
		return generateSecretKey(DEFAULT_SEED);
	}
	public static SecretKey generateSecretKey(Integer seed) {
		SecretKey result = null;
		if(seed==128 || seed==192 || seed==256){
			log.info("產生長度 {} 的SecreKey", seed );
		}else {
			log.warn("輸入長度為 {}, 已自動修正為 {}; 此值僅可為 128、192、或 256 ", seed, DEFAULT_SEED);			
			seed = DEFAULT_SEED;
		}
		
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(seed);
//			keyGenerator.init(new SecureRandom());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static String generateSecretKeyString() {
		String result = null;
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			result = Hex.encodeHexString(byteKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 產生 SecretKey 的方式.b
	public static SecretKey getSecretKeyFromPassword(String password, String salt) 
				throws NoSuchAlgorithmException, InvalidKeySpecException {
	    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	    KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
	    SecretKey key = new SecretKeySpec(factory.generateSecret(keySpec).getEncoded(), "AES");
//	    byte[] encodedKey = key.getEncoded();
//	    log.info("SecreKey={}", bytesToHexString(encodedKey));
//	    log.info("SecreKey={}", key.getEncoded());
//	    DevTool.showAllFields(key);
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

	public static String encrypt(String algorithm, String plainText, SecretKey key, IvParameterSpec iv) 
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
	
	public static String decrypt(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv) 
	    		throws NoSuchPaddingException
	    			 , NoSuchAlgorithmException
	    			 , InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    byte[] plainText = cipher.doFinal(Base64.getDecoder()
		        .decode(cipherText));
		    return new String(plainText);
		}

	public static void main(String[] args) throws InvalidKeySpecException {
		String plainText="1234567890";		// 明文
		String cipherText;					// 密文: 在明文上, 使用 密鑰+密(明)碼 所產生的
		String password="qwert";			// 加密用的密碼			
		String decryptedCipherText;					// 使用密鑰加密明碼、產生的密文	s s
		
		try {
			secretKey = generateSecretKey();
//			secretKey = getSecretKeyFromPassword(password, salt);
			iv = generateIv();
			cipherText = encrypt(algorithm, plainText, secretKey, iv);
			decryptedCipherText=decrypt(algorithm, cipherText, secretKey, iv);
			log.info("plainText={}", plainText);
			log.info("cipherText={}", cipherText);
			log.info("decryptedCipherText={}",  decryptedCipherText);
		} catch (NoSuchAlgorithmException e) {
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

}

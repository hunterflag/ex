package tw.idv.hunterchen.lab.aes;

import static org.junit.Assert.assertEquals;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.junit.Test;

import tw.idv.hunterchen.utility.AESUtil;

public class AESTest {

	@Test
	public void givenString_whenEncrypt_thenSuccess()
		    throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
		    BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException { 
		    
		    String input = "baeldung";
		    SecretKey key = AESUtil.generateSecretKey(128);
		    IvParameterSpec ivParameterSpec = AESUtil.generateIv();
		    String algorithm = "AES/CBC/PKCS5Padding";
		    String cipherText = AESUtil.encrypt(algorithm, input, key, ivParameterSpec);
		    String plainText = AESUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);
		    assertEquals(input, plainText);
		}
	
}

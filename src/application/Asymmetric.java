package application;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class Asymmetric {

private Cipher cipher;
	
	//constructor that initializes the cipher with the RSA algorithm
	public Asymmetric() throws Exception {
		this("RSA");
	}
	
	private Asymmetric(String ALGORITHM) throws Exception {
		cipher = Cipher.getInstance(ALGORITHM);
	}
	
	public String encrypt(String message, PublicKey publicKey) throws Exception {
		        
        String cipherText = null;
		//init
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		//encrypt
		byte[] cipherBytes = cipher.doFinal(message.getBytes());
		//convert to String
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	public String decrypt(String encrypted, PrivateKey privateKey) throws Exception{
		      
		//init
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		//convert to byte[]
		byte[] cipherBytes = Base64.getDecoder().decode(encrypted);
		//decrypt
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
	}
	
}

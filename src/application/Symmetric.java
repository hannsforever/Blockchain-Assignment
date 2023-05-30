package application;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;

public class Symmetric {

	private Cipher cipher;
	
	//Constructor with a specific key algorithm
	public Symmetric(String ALGORITHM) throws Exception{
		cipher = Cipher.getInstance(ALGORITHM);
	}
	
	//Default constructor with the AES algorithm
	public Symmetric() throws Exception{
		this("AES");
	}
	
	public String encrypt(String data, Key key) throws Exception{
		String cipherText = null;
		//init
		cipher.init(Cipher.ENCRYPT_MODE, key);
		//encrypt
		byte[] cipherBytes = cipher.doFinal(data.getBytes());
		//convert to String
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	public String decrypt(String cipherText, Key key) throws Exception{
		//init
		cipher.init(Cipher.DECRYPT_MODE, key);
		//convert to byte[]
		byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
		//decrypt
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
	}
	
}

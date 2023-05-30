package application;

import java.security.*;
import java.util.*;

import javax.crypto.spec.SecretKeySpec;

public class PredefinedCharsSecretKey {

	private static final String ALGORITHM = "AES";
	private static final String SECRET_CHARS = "thisisasecretchar";
	int keySize = 16;
	
	private static PredefinedCharsSecretKey instance;
	private Key preSecretKey;

	public PredefinedCharsSecretKey() {
		create();
	}
	
	public static PredefinedCharsSecretKey getInstance() {
        if (instance == null) {
            synchronized (PredefinedCharsSecretKey.class) {
                if (instance == null) {
                    instance = new PredefinedCharsSecretKey();
                }
            }
        }
        return instance;
    }

	public Key getPreSecretKey() {
		return preSecretKey;
	}

	public void setPreSecretKey(Key preSecretKey) {
		this.preSecretKey = preSecretKey;
	}

	public void create() {
		setPreSecretKey(new SecretKeySpec( Arrays.copyOf(SECRET_CHARS.getBytes(), keySize), ALGORITHM));
	}
	
}

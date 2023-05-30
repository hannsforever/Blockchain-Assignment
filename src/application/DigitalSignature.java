package application;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignature {
	
    private static final String ALGORITHM = "SHA256WithRSA";
    
    private Signature sig;

    public DigitalSignature() throws Exception {
        sig = Signature.getInstance(ALGORITHM);
    }

    public byte[] getSignature(String text, PrivateKey key) throws Exception {
        sig.initSign(key);
        sig.update(text.getBytes());
        return sig.sign();
    }

    public Boolean isTextAndSignatureValid(String text, byte[] signature, PublicKey key) throws Exception {
		try{
			sig.initVerify(key);
			sig.update(text.getBytes());
			return sig.verify(signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

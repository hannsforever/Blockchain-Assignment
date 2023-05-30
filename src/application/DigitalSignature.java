package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignature {
	
    private static final String ALGORITHM = "SHA256WithRSA";
    private Signature sig;
    private String sessionUsername;

    public DigitalSignature() throws Exception {
        this.sessionUsername = readSessionInformation();
        sig = Signature.getInstance(ALGORITHM);
    }

    public byte[] getSignature(String text, PrivateKey key) throws Exception {
        sig.initSign(key);
        sig.update(text.getBytes());
        return sig.sign();
    }

    public Boolean isTextAndSignatureValid(String text, byte[] signature, PublicKey key) throws Exception {
        try {
            sig.initVerify(key);
            sig.update(text.getBytes());
            byte[] signatureBytes = Base64.getDecoder().decode(signature);
            return sig.verify(signatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String readSessionInformation() {
        try {
            byte[] sessionBytes = Files.readAllBytes(Paths.get("session.txt"));
            return new String(sessionBytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., throw a custom exception or return a default value
        }
        return null; // Session information not found or error occurred
    }

}

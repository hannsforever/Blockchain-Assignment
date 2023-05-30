package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class MyKeyPair {

    private static final String ALGORITHM = "RSA";
    private static final String KEY_DIRECTORY = "keys";
    private static final String PUBLIC_KEY_FILE = "PublicKey.pem";
    private static final String PRIVATE_KEY_FILE = "PrivateKey.pem";

    private KeyPairGenerator keygen;
    private KeyPair keyPair;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    private MyKeyPair() {
        try {
            keygen = KeyPairGenerator.getInstance(ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MyKeyPair generateKeyPair() {
        MyKeyPair keyPair = new MyKeyPair();
        keyPair.keyPair = keyPair.keygen.generateKeyPair();
        keyPair.publicKey = keyPair.keyPair.getPublic();
        keyPair.privateKey = keyPair.keyPair.getPrivate();

        keyPair.saveKey(keyPair.publicKey.getEncoded(), PUBLIC_KEY_FILE);
        keyPair.saveKey(keyPair.privateKey.getEncoded(), PRIVATE_KEY_FILE);

        return keyPair;
    }

    private void saveKey(byte[] keyBytes, String filename) {
        try {
            if (filename == null) {
                throw new IllegalArgumentException("Filename cannot be null");
            }

            Path directoryPath = Paths.get(KEY_DIRECTORY);
            Files.createDirectories(directoryPath);

            File file = new File(directoryPath.toFile(), filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(keyBytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

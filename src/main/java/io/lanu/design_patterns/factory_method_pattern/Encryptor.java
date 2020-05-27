package io.lanu.design_patterns.factory_method_pattern;

import java.io.FileOutputStream;
import java.io.IOException;

public abstract class Encryptor {
    public void writeToDisk(String plaintext, String filename) {
        EncryptionAlgorithm encryptionAlgorithm = getEncryptionAlgorithm();
        String cyphertext = encryptionAlgorithm.encrypt(plaintext);
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            outputStream.write(cyphertext.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract EncryptionAlgorithm getEncryptionAlgorithm();
}

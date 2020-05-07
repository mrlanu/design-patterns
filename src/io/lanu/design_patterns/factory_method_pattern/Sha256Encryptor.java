package io.lanu.design_patterns.factory_method_pattern;


public class Sha256Encryptor extends Encryptor {
    @Override
    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return new Sha256CEncryptionAlgorithm();
    }
}

package io.lanu.design_patterns.factory_method_pattern;

public class PersistedFile {
    private final String path;
    private final String contents;
    private final Encryptor encryptor;
    public PersistedFile(String path, String contents, Encryptor encryptor) {
        this.path = path;
        this.contents = contents;
        this.encryptor = encryptor;
    }
    public void persist() {
        encryptor.writeToDisk(contents, path);
    }

    public static void main(String[] args) {
        PersistedFile file = new PersistedFile("/foo/bar/text.txt", "Hello, world!", new Sha256Encryptor());
        file.persist();
    }
}

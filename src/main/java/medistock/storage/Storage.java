package medistock.storage;

import java.nio.file.Path;

public class Storage {
    private final Path filePath;

    public Storage(Path filePath) {
        this.filePath = filePath;
    }
}

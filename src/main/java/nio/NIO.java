package nio;

import java.io.IOException;

/**
 * Created by Dell on 1/12/2016.
 */
public interface NIO {
    void showPathInformation(String path);

    void showFilesInformation(String path);

    void copyFiles(String sourcePath, String destinationPath);
}

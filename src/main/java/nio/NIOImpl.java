package nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Concrete class of <code>NIO</code> interface
 * this class provides methods to manipulate paths and files
 *
 * @author Thinh Diep
 * @version 1.0
 */
public class NIOImpl implements NIO {

    /**
     * Show all information of the given path
     *
     * @param path The path to show information
     */
    @Override
    public void showPathInformation(String path) {
        Path currentPath = Paths.get(path);
        if (Files.exists(currentPath)) {
            System.out.println("The absolute path is: " + currentPath.toAbsolutePath());
            System.out.println("The URI path is: " + currentPath.toUri());
        } else {
            System.out.println("The file/folder does not exist ");
        }
    }
}

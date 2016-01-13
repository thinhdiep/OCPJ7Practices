package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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
    public void showPathInformation(String path){
        Path currentPath = Paths.get(path);

        if (Files.exists(currentPath)) {
            System.out.println("The absolute path is: " + currentPath.toAbsolutePath());
            System.out.println("The URI path is: " + currentPath.toUri());
            System.out.println("The normalized path is: " + currentPath.normalize());

        } else {
            System.out.println("The file/folder does not exist ");
        }
    }

    @Override
    public void showFilesInformation(String path) {
        Path currentPath = Paths.get(path);
        Object object;

        if (Files.exists(currentPath) && !Files.isDirectory(currentPath)) {
            try {
                /*
                 * Method 1 to get files attributes
                 */
//                object = Files.getAttribute(currentPath, "creationTime", LinkOption.NOFOLLOW_LINKS);
//
//                System.out.println("Creation time is: " + object);
//                object = Files.getAttribute(currentPath, "size", LinkOption.NOFOLLOW_LINKS);
//
//                System.out.println("Size is: " + object);
//                object = Files.getAttribute(currentPath, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
//
//                System.out.println("Lat modified time is: " + object);


                /*
                 * Method 2 to get files attributes
                 */

                BasicFileAttributes fileAttributes = Files.readAttributes(currentPath, BasicFileAttributes.class);
                System.out.println("Size is: " + fileAttributes.size());
                System.out.println("Last modified time is: " + fileAttributes.lastModifiedTime());
                System.out.println("Last access time is: " + fileAttributes.lastAccessTime());
                System.out.println("Creation time " + fileAttributes.creationTime());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist ");
        }
    }

    @Override
    public void copyFiles(String sourcePath, String destinationPath) {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("copy successfull");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

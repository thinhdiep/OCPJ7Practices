package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Administrator on 1/19/2016.
 */
public class FileVisitorForCopying extends SimpleFileVisitor<Path> {
    private Path baseLocation;
    private Path targetLocation;

    public FileVisitorForCopying(Path baseLocation, Path targetLocation) {
        this.baseLocation = baseLocation;
        this.targetLocation = targetLocation;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        moveFiles(baseLocation, dir, targetLocation);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        moveFiles(baseLocation, file, targetLocation);
        return FileVisitResult.CONTINUE;
    }

    private void moveFiles(Path baseLocation, Path dir, Path targetLocation) throws IOException {
        Path copiedPath = targetLocation.resolve(baseLocation.relativize(dir));
        Files.copy(dir, copiedPath, StandardCopyOption.REPLACE_EXISTING);
    }
}

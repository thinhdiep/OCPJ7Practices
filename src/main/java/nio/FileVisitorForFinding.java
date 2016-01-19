package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 1/19/2016.
 */
public class FileVisitorForFinding extends SimpleFileVisitor<Path> {
    private PathMatcher pathMatcher;
    private List<Path> result;

    public FileVisitorForFinding(String pattern, List<Path> result) {
        pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        find(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    private List<Path> find (Path path) {
        System.out.println(" enter here");
        if (pathMatcher.matches(path.getFileName())) {
            System.out.println("matched ");
            result.add(path);
        }
        return result;
    }
}

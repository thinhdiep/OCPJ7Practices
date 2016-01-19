import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * Created by Administrator on 1/19/2016.
 */
public class Test2 {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:\\.*.txt");
        System.out.println("dddd " + matcher.matches(Paths.get("E:\\TestNIO\\Test.txt").getFileName()));
    }
}

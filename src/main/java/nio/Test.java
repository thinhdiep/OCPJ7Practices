package nio;

import nio.FileVisistorForReading;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 1/18/2016.
 */


    // Our File visitor implementation that performs copy
    class MyFileCopyVisitor extends SimpleFileVisitor<Path> {

        public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
            Test.list.add(path.getFileName().toString());
            return FileVisitResult.CONTINUE;
        }
    }

    public class Test {
        static List<String> list = new LinkedList<>();
        public static void main(String[] args) throws IOException {

//            Path pathSource = Paths.get("E:\\TestNIO");
//            Path pathDestination = Paths.get("E:\\CopyTestNewIO");
//            try {
//                Files.walkFileTree(pathSource, new nio.MyFileCopyVisitor(pathSource, pathDestination));
//                System.out.println("Files copied successfully!");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
               Path delep = Paths.get("E:\\Error");
            Files.walkFileTree(delep, new MyFileCopyVisitor());
//            Collections.reverse(list);
            StringBuilder sb = new StringBuilder("E:\\");
            for(String s : list) {
                sb.append(s).append(File.separator);
            }
            String st = sb.substring(0, sb.lastIndexOf(File.separator) - 2);
            st = st + File.separator + "1";
            File file = new File(st);
            System.out.println(st);
//            while (file.getParentFile() != null) {
//
//                doSt(file);
//                file = file.getParentFile();
//            }
            System.out.println(file.listFiles().length);
            doSt(file);

        System.out.println(list.size());
        }

        private static boolean doSt(File file) {
            if (file.getName().equalsIgnoreCase("Error")) {
                return false;
            }
            if (file.listFiles() != null) {
                for (File f : file.listFiles()) {
                    try {FileUtils.deleteDirectory(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            doSt(file.getParentFile());
            return true;
        }
    }


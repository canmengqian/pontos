package org.example;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpringAnnotStatistic
 * @Description TODO
 * @Author zhengzz
 * Date 2021/3/22
 * @Version 1.0.0
 */
public class SpringAnnotStatistic {
    private static List<Path> paths = new ArrayList<>();

    public static void main(String[] args) {
        Path path = Paths.get("C:/Users/Jano/Downloads");
    }

    private static List<Path> walk(Path path) throws IOException {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {

            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    walk(entry);
                }
                paths.add(entry);
            }
        }
        return paths;
    }
}

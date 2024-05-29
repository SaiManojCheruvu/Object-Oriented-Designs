package umbcs680.FileSystem;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static FileSystem getFileSystem(){
        FileSystem fileSystem = FileSystem.getInstance();
        Directory repo = new Directory(null, "repo", 0, LocalDateTime.of(2024, 3, 26, 8, 20));
        Directory src = new Directory(repo, "src", 0, LocalDateTime.of(2024, 3, 26, 8, 21));
        Directory main = new Directory(src, "main", 0, LocalDateTime.of(2024, 3, 26, 8, 22));
        Directory test = new Directory(src, "test", 0, LocalDateTime.of(2024, 3, 26, 8, 23));
        File readmeMd = new File(repo, "readme.md", 10,LocalDateTime.of(2024, 3, 26, 8, 24));
        File AJava = new File(main, "A.java", 20, LocalDateTime.of(2024, 3, 26, 8, 25));
        File BJava = new File(main, "B.Java", 30, LocalDateTime.of(2024, 3, 26, 8, 26));
        File ATestJava = new File(test, "ATest.java", 40, LocalDateTime.of(2024, 3, 26, 8, 27));
        File BTestJava = new File(test, "BTest.java", 50, LocalDateTime.of(2024, 3, 26, 8, 28));
        fileSystem.appendRootDir(repo);
        repo.appendChild(src);
        repo.appendChild(readmeMd);
        src.appendChild(main);
        src.appendChild(test);
        main.appendChild(AJava);
        main.appendChild(BJava);
        test.appendChild(ATestJava);
        test.appendChild(BTestJava);
        return  fileSystem;
    }
}

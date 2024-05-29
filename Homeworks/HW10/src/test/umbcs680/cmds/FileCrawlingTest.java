package umbcs680.cmds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.fs.Directory;
import umbcs680.fs.File;
import umbcs680.fs.FileSystem;
import umbcs680.fs.TestFixtureInitializer;
import umbcs680.util.FileCrawlingVisitor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void file_Crawling_Visitor(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = repo.getSubDirectories().get(0);
        Directory main = src.getSubDirectories().get(0);
        FileCrawling fileCrawling = new FileCrawling();
        File A = main.getFiles().get(0);
        File B = main.getFiles().get(1);
        assertIterableEquals(List.of(A, B), fileCrawling.execute(main));
    }

}
package umbcs680.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.fs.Directory;
import umbcs680.fs.File;
import umbcs680.fs.FileSystem;
import umbcs680.fs.TestFixtureInitializer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void file_Search_Visitor(){
        Directory repo = fileSystem.getRootDirs().get(0);
        File readmeMd = repo.getFiles().get(0);
        FileSearchVisitor visitor = new FileSearchVisitor("readme.md");
        repo.accept(visitor);
        assertIterableEquals(List.of(readmeMd), visitor.getFoundFiles());
    }

}
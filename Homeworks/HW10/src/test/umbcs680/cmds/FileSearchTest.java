package umbcs680.cmds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.fs.Directory;
import umbcs680.fs.File;
import umbcs680.fs.FileSystem;
import umbcs680.fs.TestFixtureInitializer;
import umbcs680.util.FileSearchVisitor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void file_Search_Visitor(){
        Directory repo = fileSystem.getRootDirs().get(0);
        File readmeMd = repo.getFiles().get(0);
        FileSearch fileSearch = new FileSearch("readme.md");
        assertIterableEquals(List.of(readmeMd), fileSearch.execute(repo));
    }

}
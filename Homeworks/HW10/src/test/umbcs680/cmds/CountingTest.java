package umbcs680.cmds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.fs.Directory;
import umbcs680.fs.FileSystem;
import umbcs680.fs.TestFixtureInitializer;
import umbcs680.util.CountingVisitor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountingTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void counting_visitor(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Counting counting = new Counting();
        assertIterableEquals(List.of(4, 5, 1), counting.execute(repo));
    }

}
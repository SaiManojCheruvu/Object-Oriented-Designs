package umbcs680.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.fs.Directory;
import umbcs680.fs.FileSystem;
import umbcs680.fs.TestFixtureInitializer;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void counting_visitor(){
        Directory repo = fileSystem.getRootDirs().get(0);
        CountingVisitor visitor = new CountingVisitor();
        repo.accept(visitor);
        assertEquals(4, visitor.getDirNum());
        assertEquals(5, visitor.getFileNum());
        assertEquals(1, visitor.getLinkNum());
    }

}
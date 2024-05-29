package umbcs680.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    private static FileSystem fileSystem1;
    private static FileSystem fileSystem2;
    @BeforeAll
    public static void setUp(){
        fileSystem1 = TestFixtureInitializer.getFileSystem();
        fileSystem2 = TestFixtureInitializer.getFileSystem();
    }
    private String[] dirToStringArray(Directory d){
        return new String[]{d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime())};
    }
    @Test
    public void singletonTest(){
        assertNotNull(fileSystem1);
        assertNotNull(fileSystem2);
        assertSame(fileSystem1, fileSystem2);
        assertEquals(fileSystem1.hashCode(), fileSystem2.hashCode());
    }

}
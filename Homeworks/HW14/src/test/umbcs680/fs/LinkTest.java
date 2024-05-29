package umbcs680.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    private String[] fileToStringArray(File f){
        return new String[]{f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }
    @Test
    public void getTargetTest(){
        Link rmmd = (Link)fileSystem.getRootDirs().get(0).getSubDirectories().get(0).getSubDirectories().get(1).getChildren().get(2);
        String[] expected = {"readme.md", "10", "2024-03-26T08:24"};
        assertArrayEquals(expected, fileToStringArray((File) rmmd.getTarget()));
    }
    @Test
    public void Link_Size_0_Test(){
        Link rmmd = (Link)fileSystem.getRootDirs().get(0).getSubDirectories().get(0).getSubDirectories().get(1).getChildren().get(2);
        assertEquals(0, rmmd.getSize());

    }

}
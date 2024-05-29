package umbcs680.FileSystem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    private String[] fileToStringArray(File f){
        return new String[]{f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }
    @Test
    public void AJavaTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = repo.getSubDirectories().get(0);
        Directory main = src.getSubDirectories().get(0);
        File AJava = main.getFiles().get(0);
        String[] expected = {"A.java", "20", "2024-03-26T08:25"};
        assertArrayEquals(expected, fileToStringArray(AJava));
    }
    @Test
    public void isDirectoryTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = repo.getSubDirectories().get(0);
        Directory main = src.getSubDirectories().get(0);
        Directory test = src.getSubDirectories().get(1);
        File AJava = main.getFiles().get(0);
        File BJava = main.getFiles().get(1);
        File readmeMd = repo.getFiles().get(0);
        File ATestJava = test.getFiles().get(0);
        File BTestJava = test.getFiles().get(1);
        assertFalse(AJava.isDirectory());
        assertFalse(BJava.isDirectory());
        assertFalse(readmeMd.isDirectory());
        assertFalse(ATestJava.isDirectory());
        assertFalse(BTestJava.isDirectory());

    }

}
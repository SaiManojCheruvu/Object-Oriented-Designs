package umbcs680.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    private String[] dirToStringArray(Directory d){
        return new String[]{d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime())};
    }
    private String[] fileToStringArray(File f){
        return new String[]{f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }

    @Test
    public void appendChildTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        repo.appendChild(new Directory(repo, "testing", 0, LocalDateTime.of(2024, 3, 26, 8, 20)));
        String[] expected = {"testing", "0", "2024-03-26T08:20" };
        assertArrayEquals(expected, dirToStringArray(repo.getSubDirectories().get(1)));
        repo.getChildren().remove(repo.getChildren().size() - 1);
    }
    @Test
    public void getChildrenTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(0);
        String[] expected = {"src", "0", "2024-03-26T08:21" };
        assertArrayEquals(expected, dirToStringArray(src));
        File readmeMd = (File) repo.getChildren().get(1);
        expected = new String[]{"readme.md", "10", "2024-03-26T08:24"};
        assertArrayEquals(expected, fileToStringArray(readmeMd));
    }
    @Test
    public void countChildrenTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        assertEquals(2, repo.countChildren());
    }
    @Test
    public void getFilesTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        File readmeMd = repo.getFiles().get(0);
        String[] expected = {"readme.md", "10", "2024-03-26T08:24"};
        assertArrayEquals(expected, fileToStringArray(readmeMd));
    }
    @Test
    public void getTotalSizeTest(){
        Directory repo = fileSystem.getRootDirs().get(0);
        assertEquals(150, repo.getTotalSize());
    }





}
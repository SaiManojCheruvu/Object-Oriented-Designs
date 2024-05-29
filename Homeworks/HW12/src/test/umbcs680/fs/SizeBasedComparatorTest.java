package umbcs680.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SizeBasedComparatorTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void getChildren_Size_Based_Comparator_Test(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(1);
        Directory test = (Directory) src.getChildren().get(1);
        File aTest = (File) test.getFiles().get(0);
        File bTest = (File) test.getFiles().get(1);
        Link rmmd = (Link) test.getLinks().get(0);
        assertIterableEquals(List.of(bTest, aTest, rmmd), test.getChildren(new SizeBasedComparator()));
    }
    @Test
    public void getSubDirectories_Size_Based_Comparator_Test(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(1);
        Directory main = (Directory) src.getChildren().get(0);
        Directory test = (Directory) src.getChildren().get(1);
        assertIterableEquals(List.of(main, test), src.getSubDirectories(new SizeBasedComparator()));
    }
    @Test
    public void getFiles_Size_Based_Comparator_Test(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(1);
        Directory test = (Directory) src.getChildren().get(1);
        File aTest = (File) test.getFiles().get(0);
        File bTest = (File) test.getFiles().get(1);
        assertIterableEquals(List.of(bTest, aTest), test.getFiles(new SizeBasedComparator()));
    }

}
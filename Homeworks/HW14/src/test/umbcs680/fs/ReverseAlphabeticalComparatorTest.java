package umbcs680.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlphabeticalComparatorTest {
    private static FileSystem fileSystem;
    @BeforeAll
    public static void setUp(){
        fileSystem = TestFixtureInitializer.getFileSystem();
    }
    @Test
    public void getChildren_Reverse_Alphabetical_Comparator_Test(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(1);
        Directory test = (Directory) src.getChildren().get(1);
        File aTest = (File) test.getFiles().get(0);
        File bTest = (File) test.getFiles().get(1);
        Link rmmd = (Link) test.getLinks().get(0);
        assertIterableEquals(List.of(rmmd, bTest, aTest), test.getChildren(Comparator.comparing((FSElement::getName), Comparator.reverseOrder())));
    }
    @Test
    public void getSubDirectories_Reverse_Alphabetical_Comparator_Test(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(1);
        Directory main = (Directory) src.getChildren().get(0);
        Directory test = (Directory) src.getChildren().get(1);
        assertIterableEquals(List.of(test, main), src.getSubDirectories(Comparator.comparing((FSElement::getName), Comparator.reverseOrder())));
    }
    @Test
    public void getFiles_Reverse_Alphabetical_Comparator_Test(){
        Directory repo = fileSystem.getRootDirs().get(0);
        Directory src = (Directory) repo.getChildren().get(1);
        Directory test = (Directory) src.getChildren().get(1);
        File aTest = (File) test.getFiles().get(0);
        File bTest = (File) test.getFiles().get(1);
        assertIterableEquals(List.of(bTest, aTest), test.getFiles(Comparator.comparing((FSElement::getName), Comparator.reverseOrder())));
    }

}
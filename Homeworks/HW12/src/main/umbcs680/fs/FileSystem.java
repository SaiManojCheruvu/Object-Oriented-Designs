package umbcs680.fs;

import java.util.LinkedList;
import java.util.Objects;

public class FileSystem {
    private static FileSystem instance = null;
    private FileSystem(){}
    private LinkedList<Directory> rootDirs = new LinkedList<>();
    public static FileSystem getInstance() {
        try {
            return Objects.requireNonNull(instance);
        }catch (NullPointerException e){
            instance = new FileSystem();
            return instance;
        }
    }
    public void appendRootDir(Directory root){
        this.rootDirs.add(root);
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }
}

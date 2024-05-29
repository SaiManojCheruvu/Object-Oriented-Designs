package umbcs680.util;

import umbcs680.fs.Directory;
import umbcs680.fs.FSVisitor;
import umbcs680.fs.File;
import umbcs680.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {
    private String fileName;
    private LinkedList<File> foundFiles;
    public FileSearchVisitor(String fileName){
        this.fileName = fileName;
        this.foundFiles = new LinkedList<>();
    }
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if(file.getName().equals(fileName)){
            foundFiles.add(file);
        }
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }
}

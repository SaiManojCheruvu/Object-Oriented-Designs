package umbcs680.util;

import umbcs680.fs.Directory;
import umbcs680.fs.FSVisitor;
import umbcs680.fs.File;
import umbcs680.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {
    private LinkedList<File> files;
    public FileCrawlingVisitor(){
        this.files = new LinkedList<>();
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
        files.add(file);
    }

    public LinkedList<File> getFiles() {
        return files;
    }
}

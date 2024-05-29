package umbcs680.util;

import umbcs680.fs.Directory;
import umbcs680.fs.FSVisitor;
import umbcs680.fs.File;
import umbcs680.fs.Link;

public class CountingVisitor implements FSVisitor {
    private int dirNum;
    private int fileNum;
    private int linkNum;
    public CountingVisitor(){
        this.dirNum = 0;
        this.fileNum = 0;
        this.linkNum = 0;
    }

    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    @Override
    public void visit(File file) {
        fileNum++;
    }

    public int getLinkNum() {
        return linkNum;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }
}

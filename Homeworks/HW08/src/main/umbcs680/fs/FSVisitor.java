package umbcs680.fs;

import umbcs680.fs.Directory;
import umbcs680.fs.File;
import umbcs680.fs.Link;


public interface FSVisitor {
    public abstract void visit(Link link);
    public abstract void visit(Directory dir);
    public abstract void visit(File file);

}

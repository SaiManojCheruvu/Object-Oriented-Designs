package umbcs680.cmds;

import umbcs680.fs.FSCommand;
import umbcs680.fs.FSElement;
import umbcs680.fs.File;
import umbcs680.util.FileCrawlingVisitor;

import java.util.LinkedList;
import java.util.List;

public class FileCrawling implements FSCommand {
    private List<File> files;
    private final FileCrawlingVisitor visitor;
    public FileCrawling(){
        this.files = new LinkedList<>();
        this.visitor = new FileCrawlingVisitor();
    }

    @Override
    public List<File> execute(FSElement element) {
        element.accept(visitor);
        return visitor.getFiles();
    }
}

package umbcs680.cmds;

import umbcs680.fs.FSCommand;
import umbcs680.fs.FSElement;
import umbcs680.fs.File;
import umbcs680.util.FileSearchVisitor;

import java.util.List;

public class FileSearch implements FSCommand {
    private final FileSearchVisitor fileSearchVisitor;
    public FileSearch(String searchString){
        this.fileSearchVisitor = new FileSearchVisitor(searchString);
    }
    @Override
    public List<File> execute(FSElement element) {
        element.accept(fileSearchVisitor);
        return fileSearchVisitor.getFoundFiles();
    }
}

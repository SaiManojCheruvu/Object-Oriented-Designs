package umbcs680.cmds;

import umbcs680.fs.FSCommand;
import umbcs680.fs.FSElement;
import umbcs680.util.CountingVisitor;

import java.util.List;

public class Counting implements FSCommand {
    private final CountingVisitor countingVisitor;
    public Counting(){
        this.countingVisitor = new CountingVisitor();
    }
    @Override
    public List<Integer> execute(FSElement element) {
        element.accept(countingVisitor);
        return List.of(countingVisitor.getDirNum(), countingVisitor.getFileNum(), countingVisitor.getLinkNum());
    }
}

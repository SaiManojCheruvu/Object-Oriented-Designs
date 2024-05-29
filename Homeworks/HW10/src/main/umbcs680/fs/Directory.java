package umbcs680.fs;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Directory extends FSElement{
    private LinkedList<FSElement> children;
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new LinkedList<>();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e:getChildren()){
            e.accept(v);
        }
    }

    public void appendChild(FSElement child){
        children.add(child);
    }
    public List<FSElement> getChildren(){
        return this.children;
    }
    public int countChildren(){
        return children.size();
    }
    public List<Directory> getSubDirectories(){
        List<Directory> subDirectories = new LinkedList<>();
        for(int i = 0; i <= children.size() - 1; i++){
            FSElement currentChild = children.get(i);
            if(currentChild.isDirectory()){
                subDirectories.add((Directory) currentChild);
            }
        }
        return subDirectories;
    }
    public List<File> getFiles(){
        List<File> files = new LinkedList<>();
        for(int i = 0; i <= children.size() - 1; i++){
            FSElement currentChild = children.get(i);
            if(!currentChild.isDirectory() && !currentChild.isLink()){
                files.add((File) currentChild);
            }
        }
        return files;
    }
    public int getTotalSize(){
        int size=0;
        for(int i = 0; i <= getChildren().size() - 1; i++){
            FSElement fselement = getChildren().get(i);
            if(fselement instanceof Directory) {
                size = size + ((Directory)fselement).getTotalSize();
            }
            else{
                size = size +fselement.getSize();
            }
        }
        return size;
    }
}


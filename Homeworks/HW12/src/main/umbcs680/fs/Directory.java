package umbcs680.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(children, new AlphabeticalComparator());
        return children;
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
        Collections.sort(subDirectories, new AlphabeticalComparator());
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
        Collections.sort(files, new AlphabeticalComparator());
        return files;
    }
    public List<Link> getLinks(){
        List<Link> links = new LinkedList<>();
        for (int i = 0; i <= children.size() - 1; i++){
            FSElement currentChild = children.get(i);
            if (currentChild.isLink()){
                links.add((Link) currentChild);
            }
        }
        Collections.sort(links, new AlphabeticalComparator());
        return links;
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
    public List<FSElement> getChildren(Comparator<FSElement> comparator){
        List<FSElement> children = getChildren();
        Collections.sort(children, comparator);
        return children;
    }
    public List<Directory> getSubDirectories(Comparator<FSElement> comparator){
        List<Directory> subDirectories = getSubDirectories();
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }
    public List<File> getFiles(Comparator<FSElement> comparator){
        List<File> files = getFiles();
        Collections.sort(files, comparator);
        return files;
    }
    public List<Link> getLinks(Comparator<FSElement> comparator){
        List<Link> links = getLinks();
        Collections.sort(links, comparator);
        return links;
    }
}


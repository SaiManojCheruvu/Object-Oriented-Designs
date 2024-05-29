package umbcs680.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Directory extends FSElement {
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
        getChildren().forEach(e -> e.accept(v));
    }

    public void appendChild(FSElement child) {
        children.add(child);
    }

    public List<FSElement> getChildren() {
        Collections.sort(children, Comparator.comparing(FSElement::getName));
        return children;
    }

    public int countChildren() {
        return children.size();
    }

    public List<Directory> getSubDirectories() {
        List<Directory> subDirectories = new LinkedList<>();
        getChildren().forEach(currentChild -> {
            if (currentChild.isDirectory()) {
                subDirectories.add((Directory) currentChild);
            }
        });
        Collections.sort(subDirectories, Comparator.comparing(FSElement::getName));
        return subDirectories;
    }

    public List<File> getFiles() {
        List<File> files = new LinkedList<>();
        getChildren().forEach(currentChild -> {
            if (!currentChild.isDirectory() && !currentChild.isLink()) {
                files.add((File) currentChild);
            }
        });
        Collections.sort(files, Comparator.comparing(FSElement::getName));
        return files;
    }

    public List<Link> getLinks() {
        List<Link> links = new LinkedList<>();
        getChildren().forEach(currentChild -> {
            if (currentChild.isLink()) {
                links.add((Link) currentChild);
            }
        });
        Collections.sort(links, Comparator.comparing(FSElement::getName));
        return links;
    }

    public int getTotalSize() {
        int[] size = new int[1];
        getChildren().forEach(fselement -> {
            if (fselement instanceof Directory) {
                size[0] += ((Directory) fselement).getTotalSize();
            } else {
                size[0] += fselement.getSize();
            }
        });
        return size[0];
    }

    public List<FSElement> getChildren(Comparator<FSElement> comparator) {
        List<FSElement> children = getChildren();
        Collections.sort(children, comparator);
        return children;
    }

    public List<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        List<Directory> subDirectories = getSubDirectories();
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }

    public List<File> getFiles(Comparator<FSElement> comparator) {
        List<File> files = getFiles();
        Collections.sort(files, comparator);
        return files;
    }

    public List<Link> getLinks(Comparator<FSElement> comparator) {
        List<Link> links = getLinks();
        Collections.sort(links, comparator);
        return links;
    }
}

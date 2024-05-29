package umbcs680.FileSystem;

import java.time.LocalDateTime;

public class Link extends FSElement{
    private FSElement target;
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, 0, creationTime);
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isLink() {
        return true;
    }

    public FSElement getTarget(){
        return this.target;
    }
}

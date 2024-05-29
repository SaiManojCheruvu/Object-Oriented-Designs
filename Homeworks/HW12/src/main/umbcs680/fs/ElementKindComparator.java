package umbcs680.fs;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        if (o1.isDirectory() && !o2.isDirectory()) {
            return -1;
        } else if (!o1.isDirectory() && o2.isDirectory()) {
            return 1;
        } else {
            return 0;
        }
    }
}

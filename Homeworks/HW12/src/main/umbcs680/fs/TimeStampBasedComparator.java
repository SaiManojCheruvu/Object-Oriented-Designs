package umbcs680.fs;

import java.util.Comparator;

public class TimeStampBasedComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getCreationTime().compareTo(o1.getCreationTime());
    }
}

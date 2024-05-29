package umbcs680.fs;

import java.util.List;

public interface FSCommand<T> {
    public abstract List<T> execute(FSElement element);
}

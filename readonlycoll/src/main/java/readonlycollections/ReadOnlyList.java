package readonlycollections;

import java.util.List;

public interface ReadOnlyList<T> extends ReadOnlyCollection<T> {

    T get(int index);

    List<T> asRuntimeReadOnly();
}

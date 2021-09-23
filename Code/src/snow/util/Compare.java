package snow.util;

@FunctionalInterface
public interface Compare<K> {
    boolean bigger(K first, K second);
}

package snow.util;

public class SkipList<K, V> {    
    private int size;
    private int levelCount;
    private final Point<K, V> header;
    private final int MAX_LEVEL = 16;
    private final Compare<K> compare;

    /**
     * Constructor
     * @param minKey minimum value of Type K
     * @param compare compare Method of Type K
     */
    public SkipList(K minKey, Compare<K> compare){
        size = 0;
        levelCount = 0;
        header = new Point<>(minKey, null, MAX_LEVEL);
        this.compare = compare;
    }

    /**
     * Add an element to List
     * @param key Key
     * @param value Value
     */
    @SuppressWarnings("unchecked")
    public void add(K key, V value){
        Point<K, V> point = getPoint(key);
        if (point != null) {
            point.value = value;
            return;
        }
        int level = randomLevel();
        Point<K, V> newPoint = new Point<>(key, value, level);
        Point<K, V>[] update = new Point[level];
        for (int i = 0; i < level; i++) {
            update[i] = header;
        }
        record(update, key, level);

        for (int i = 0; i < level; i++) {
            newPoint.next[i] = update[i].next[i];
            update[i].next[i] = newPoint;
        }
        if (levelCount < level) {
            levelCount = level;
        }
        size++;
    }

    /**
     * Get a point from the list using a key
     * @param key the key
     * @return the point or null
     */
    private Point<K, V> getPoint(K key) {
        Point<K, V> point = header;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (point.next[i] != null && compare.bigger(key, point.next[i].key)) {
                point = point.next[i];
            }
        }
        if (point.next[0] != null && point.next[0].key.equals(key)) {
            return point.next[0];
        }
        return null;
    }

    /**
     * Get an element with Key
     * @param key Key
     * @return null if no such Key exist or Value
     */
    public V get(K key) {
        Point<K, V> point = getPoint(key);
        if (point != null) {
            return point.value;
        }
        return null;
    }

    /**
     * get a level randomly between 1 and MAX_LEVEL
     * @return level
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private void record(Point<K, V>[] update, K key, int level) {
        Point<K, V> point = header;
        for (int i = level-1; i >= 0; i--) {
            while (point.next[i] != null && compare.bigger(key, point.next[i].key)) {
                point = point.next[i];
            }
            update[i] = point;
        }
    }

    /**
     * Size of the List
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * show whole List
     */
    public void show() {
        Point<K, V> level = header;
        for (int i = levelCount-1; i >= 0; i--) {
            System.out.print("Level " + i + "| " + "{" + level.next[i].key + ": " + level.next[i].value + "}");
            Point<K, V> temp = level.next[i].next[i];
            while (temp != null) {
                System.out.print(" -> " + "{" + temp.key + ": " + temp.value + "}");
                temp = temp.next[i];
            }
            System.out.println();
        }
    }

    private static class Point<K, V> {
        public Point<K, V>[] next;
        private final K key;
        private V value;

        @SuppressWarnings("unchecked")
        private Point(K key, V value, int level) {
            this.key = key;
            this.value = value;
            next = new Point[level];
        }

    }
}


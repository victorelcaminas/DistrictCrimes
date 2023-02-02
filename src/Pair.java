import java.io.Serializable;
import java.util.*;

public class Pair <K extends Comparable<K>, V>
        implements Comparable<Pair<K, V>>, Serializable {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }

    public static void main(String[] args) {
        Pair<String, String> pair1 = new Pair<>("bbbbb", "world");
        Pair<String, String> pair2 = new Pair<>("aaaaa", "world");
        Pair<String, String> pair3 = new Pair<>("ccccc", "world");
        Pair<String, String> pair4 = new Pair<>("ddddd", "world");
        List<Pair<String, String>> list = new ArrayList<>();
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        list.add(pair4);
        Collections.sort(list);
        System.out.println(list);
    }

    @Override
    public int compareTo(Pair<K, V> pair) {
        return key.compareTo(pair.key);
    }
}

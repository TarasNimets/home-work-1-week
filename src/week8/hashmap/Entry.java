package week8.hashmap;

public interface Entry<K, V> {

    boolean equals(Object o);
    int hashCode();
    K getKey();
    V getValue();
}

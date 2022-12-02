package dataStructures;

public class EntryClass<K, V> implements Entry {

    // instance variables
    private K key;
    private V value;

    public EntryClass(K key, V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    protected void setKey(K newKey) {
        key = newKey;
    }

    protected void setValue(V newValue) {
        value = newValue;
    }
}

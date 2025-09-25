package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int storageSize = 0;
    private K[] keyArray = (K[]) new Object[DEFAULT_CAPACITY];
    private V[] valueArray = (V[]) new Object[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (Objects.equals(keyArray[i], key)) {
                valueArray[i] = value;
                return;
            }
        }
        if (storageSize < DEFAULT_CAPACITY) {
            keyArray[storageSize] = key;
            valueArray[storageSize++] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}

package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

public class DB<T> implements AdvancedDB<T> {

    private final T[] objects;
    private final HashMap<String, HashMap<?, Integer>> indices;

    public DB(T[] objects) {
        this.objects = objects;
        this.indices = new HashMap<>();
    }

    @Override
    public <S> void createIndex(String indexName, Function<T, S> keyMapper) {
        HashMap<S, Integer> index = new HashMap<>();
        for (int i = 0; i < objects.length; i++) {
            var key = keyMapper.apply(objects[i]);
            index.put(key, i);
        }
        indices.put(indexName, index);
    }

    @Override
    public <S> void createMultiIndex(String indexName, Function<T, Collection<S>> keyMapper) {
        HashMap<S, Integer> index = new HashMap<>();
        for (int i = 0; i < objects.length; i++) {
            var keys = keyMapper.apply(objects[i]);
            for (S key : keys) {
                index.put(key, i);
            }
        }
        indices.put(indexName, index);
    }

    @Override
    public <S> T getBy(String indexName, S value) {
        HashMap<?, Integer> index = indices.get(indexName);
        return objects[index.get(value)];
    }
}

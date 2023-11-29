package org.example;

import java.util.Collection;
import java.util.function.Function;

// T is the type of objects in the DB (e.g. User)
public interface AdvancedDB<T> {

    // S is the type of index key  (e.g. Long for id index, String for name index)
    <S> void createIndex(String indexName, Function<T, S> keyMapper);
    <S> void createMultiIndex(String indexName, Function<T, Collection<S>> keyMapper);

    <S> T getBy(String indexName, S value);
}
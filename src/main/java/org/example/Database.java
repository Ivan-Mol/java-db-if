package org.example;

import lombok.Getter;

import java.util.Map;

@Getter
public class Database extends DB<User> {

    public Database(User... objects) {
        super(objects);
        createIndex("id", User::getId);
        createIndex("name", User::getName);

    }

    public User getById(Long id) {
        return getBy("id", id);
    }

    public User getByName(String name) {
        return getBy("name", name);
    }

}

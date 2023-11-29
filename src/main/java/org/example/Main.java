package org.example;

public class Main {
    public static void main(String[] args) {
        Database db = new Database(new User(1L, "Ivan", "Petrov"),
                new User(2L, "Sergey", "Veselov"),
                new User(3L, "Peter", "Grusnov"));
        System.out.println(db.getById(2L).getName());
    }
}
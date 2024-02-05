package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public final class DataBase {
    private static List<User> users = new ArrayList<>();
    private static List<Message> messages = new CopyOnWriteArrayList<>();

    private DataBase() {
    }

    public static List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public static List<Message> getMessages() {
        return new ArrayList<>(messages);
    }

    public static void addMessage(Message message) {
        messages.add(message);
    }

    public static void setReadOnlyModeForUser(String login, boolean mode) {
        users = users
                .stream()
                .map(x -> {
                    if (x.getLogin().equals(login)) {
                        x.setReadOnlyMode(mode);
                    }
                    return x;
                })
                .collect(Collectors.toList());
    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");

        users.add(new User("qwe", "123", "Lulu", UserType.CLIENT));
        users.add(new User("asd", "456", "Olo", UserType.CLIENT));
        users.add(new User("zxc", "789", "Lee", UserType.ADMIN));
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}

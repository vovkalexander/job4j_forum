package ru.job4j.forum.service;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
    private final HashMap<Integer, User> users = new HashMap<>();
    private final AtomicInteger key = new AtomicInteger(1);

    public UserService() {
        users.put(1, User.of("username", "123"));

    }

    public Collection<User> getAll() {
        return this.users.values();
    }

    public void addUser(User user) {
        user.setId(key.incrementAndGet());
        users.put(user.getId(), user);
    }

    public User findByNameAndPassword(String name, String pass) {
        User user = null;
       for (User currentUser : users.values()) {
           if (currentUser.getUsername().equals(name) && currentUser.getPassword().equals(pass)) {
               user = currentUser;
           }
       }
       return user;
    }
}

package ru.job4j.forum.service;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public Collection<User> getAll() {
        List<User> rsl = new ArrayList<>();
        users.findAll().forEach(rsl::add);
        return rsl;
    }

    public void addUser(User user) {
        users.save(user);
    }



    public Boolean existsByName(String name) {
        return users.existsByName(name);
    }
}

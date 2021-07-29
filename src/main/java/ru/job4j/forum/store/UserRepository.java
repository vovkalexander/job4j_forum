package ru.job4j.forum.store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
 @Query("select u from User u  where  u.username like %:username%  and  u.password like %:password%")
    User findByNameAndPassword(@Param("username") String username,
                               @Param("password") String password);
}

package ru.job4j.forum.store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select case when count(u) > 0 then true else false end from User u where u.username like %:username%")
    Boolean existsByName(@Param("username") String name);

    @Query("select u from User u where u.username like %:username%")
     User findByUser(@Param("username") String name);
}

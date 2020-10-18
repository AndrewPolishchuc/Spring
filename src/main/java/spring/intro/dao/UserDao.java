package spring.intro.dao;

import java.util.List;
import spring.intro.model.User;

public interface UserDao {
    void create(User user);

    List<User> readAll();
}

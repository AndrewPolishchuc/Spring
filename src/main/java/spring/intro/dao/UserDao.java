package spring.intro.dao;

import spring.intro.model.User;
import java.util.List;

public interface UserDao {
    void create(User user);

    List<User> readAll();
}

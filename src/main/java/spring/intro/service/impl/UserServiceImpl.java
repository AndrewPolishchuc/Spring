package spring.intro.service.impl;

import spring.intro.dao.UserDao;
import spring.intro.model.User;
import org.springframework.stereotype.Service;
import spring.intro.service.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.readAll();
    }
}

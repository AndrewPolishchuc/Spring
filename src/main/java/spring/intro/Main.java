package spring.intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Andrew", "Polishchuk", "andriipolishchuk@gmail.com");
        User user2 = new User("Vasa", "Pupkin", "vpup@gmail.com");

        userService.add(user1);
        userService.add(user2);

        userService.listUsers().forEach(System.out::println);
    }
}

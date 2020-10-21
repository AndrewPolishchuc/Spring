package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectData() {
        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setFirstName("Bob");
        bob.setLastName("Jackins");
        userService.add(bob);

        User alice = new User();
        alice.setEmail("alice@gmail.com");
        alice.setFirstName("Alisa");
        alice.setLastName("Jackins");
        userService.add(alice);
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return castUserToDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::castUserToDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto castUserToDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }
}

package ru.tolkacheva.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tolkacheva.entities.User;
import ru.tolkacheva.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void createUser(User user) {
        log.info("Create new User {}", user);
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void changeUser(Integer id, User user) {
        User newUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        log.info("User was changed {}", user);
        userRepository.save(newUser);
    }

    public void deleteUser(Integer id) {
        log.info("User was deleted");
        userRepository.deleteById(id);
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tolkacheva.entities.User;
import ru.tolkacheva.repositories.UserRepository;
import ru.tolkacheva.services.UserService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldCreateUser() {
        User user = new User(null, "test", "test@mail.com", "123");
        userService.createUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void shouldReturnUserById() {
        User user = new User(1, "test", "test@mail.com", "123");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User res = userService.getUserById(1);
        assertEquals("test", res.getName());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> userService.getUserById(1));
    }

//    @Test
//    void shouldReturnAllUsers() {
//        List<User> users = List.of(
//                new User(1, "user1", "u1@mail.com", "123"),
//                new User(2, "user2", "u2@mail.com", "123")
//        );
//
//        when(userRepository.findAll()).thenReturn(users);
//        List<User> res = userService.getAllUsers();
//        assertEquals(2, res.size());
//    }
//
//    @Test
//    void shouldUpdateUser() {
//        User existing = new User(1, "old", "old@mail.com", "old");
//        User updated = new User(null, "new", "new@mail.com", "new");
//
//        when(userRepository.findById(1)).thenReturn(Optional.of(existing));
//        userService.changeUser(1, updated);
//        assertEquals("new", existing.getName());
//        verify(userRepository).save(existing);
//    }
//
//    @Test
//    void shouldThrowWhenUpdateUserNotFound() {
//        when(userRepository.findById(1)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class,
//                () -> userService.changeUser(1, new User()));
//    }
//
//    @Test
//    void shouldDeleteUser() {
//        userService.deleteUser(1);
//        verify(userRepository).deleteById(1);
//    }
}

package ch.zli.todo.todo.service;

import ch.zli.todo.todo.UserRepository;
import ch.zli.todo.todo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository;}
    public User createUser(User user){return userRepository.saveAndFlush(user);}
    public List<User>findAll() {
        return userRepository.findAll();
    }
    public void deleteUser(long id) { userRepository.deleteById(id); }
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }

}
}

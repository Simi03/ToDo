package ch.zli.todo.todo.service;

import ch.zli.todo.todo.UserRepository;
import ch.zli.todo.todo.entity.Benutzer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserService implements UserDetailsService {
    UserRepository userRepository; // Import von Interface

    //CRUD für User
    public UserService(UserRepository userRepository) { this.userRepository = userRepository;}
    public Benutzer createUser(Benutzer benutzer){return userRepository.saveAndFlush(benutzer);}
    public List<Benutzer>findAll() {
        return userRepository.findAll();
    }
    public void deleteUser(long id) { userRepository.deleteById(id); }
    public Benutzer updateUser(Benutzer benutzer) {
        return userRepository.save(benutzer);
    }

    //User von Username finden
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Benutzer benutzer = userRepository.findByUsername(username);
        if (benutzer == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(benutzer.getUsername(), benutzer.getPassword(), emptyList());
    }

}


package ch.zli.todo.todo.controller;

import ch.zli.todo.todo.UserRepository;
import ch.zli.todo.todo.entity.Benutzer;
import ch.zli.todo.todo.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository ){this.userService = userService; this.bCryptPasswordEncoder = bCryptPasswordEncoder;this.userRepository = userRepository;}

    //Userliste ausgeben
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Benutzer> getAllUser() {
        return userRepository.findAll();
    }

    //User erstellen
   @PostMapping("/createUser")
   @ResponseStatus(HttpStatus.CREATED)
   public void createUser(@RequestBody Benutzer user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userRepository.save(user);
   }

    //User erstellen
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    //User bearbeiten
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Benutzer updateUser(@RequestBody Benutzer benutzer, @PathVariable long id) {
        Benutzer oldUser  = userRepository.findById(id).get();
        Assert.notNull(oldUser, "User not found");
        oldUser.setUsername(benutzer.getUsername());
       return userRepository.save(oldUser);
    }
}
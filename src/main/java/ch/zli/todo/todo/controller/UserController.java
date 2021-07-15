package ch.zli.todo.todo.controller;

import ch.zli.todo.todo.UserRepository;
import ch.zli.todo.todo.entity.Benutzer;
import ch.zli.todo.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder){this.userService = userService; this.bCryptPasswordEncoder = bCryptPasswordEncoder;}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Benutzer> getAllUser() {
        return userService.findAll();
    }

   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Benutzer createUser(@Valid @RequestBody Benutzer benutzer) {
        return userService.createUser(benutzer);

    }
    */
   @PostMapping("/createUser")
   @ResponseStatus(HttpStatus.CREATED)
   public void createUser(@RequestBody Benutzer user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userService.updateUser(user);
   }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Benutzer updateUser(@Valid @RequestBody Benutzer benutzer) {
        return userService.updateUser(benutzer);
    }


}
package ch.zli.todo.todo.controller;

import ch.zli.todo.todo.entity.Benutzer;
import ch.zli.todo.todo.service.UserService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> getAthletes(@RequestBody Benutzer user) {
        for (Benutzer u:userService.findAll()) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}

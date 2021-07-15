package ch.zli.todo.todo;

import ch.zli.todo.todo.entity.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Benutzer, Long> {
    Benutzer findByUsername(String username);
}

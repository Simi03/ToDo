package ch.zli.todo.todo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
spring.datasource.url=jdbc:mysql://localhost:3306/todo?serverTimezone=GMT-1
spring.datasource.username=root
spring.datasource.password=bbw123
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
 */

@Entity
public class Benutzer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;
    private String password;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}

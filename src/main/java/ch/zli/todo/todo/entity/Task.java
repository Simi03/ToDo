package ch.zli.todo.todo.entity;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne
    private Category category;

    //Getter and Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

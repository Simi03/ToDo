package ch.zli.todo.todo.controller;

import ch.zli.todo.todo.entity.Task;
import ch.zli.todo.todo.entity.User;
import ch.zli.todo.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){this.taskService = taskService;}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTask() {
        return taskService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task updateTask(@Valid @RequestBody Task task) {
        return taskService.updateTask(task);
    }
}

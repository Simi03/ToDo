package ch.zli.todo.todo.controller;

import ch.zli.todo.todo.TaskRepository;
import ch.zli.todo.todo.entity.Task;
import ch.zli.todo.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository){this.taskService = taskService; this.taskRepository = taskRepository;}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @PostMapping("/createTask")
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
    public Task updateTask(@RequestBody Task task, @PathVariable long id) {
        Task oldTask = taskRepository.findById(id).get();
        Assert.notNull(oldTask, "Task does not exist");
        oldTask.setTitle(task.getTitle());
        return taskRepository.save(oldTask);
    }
}

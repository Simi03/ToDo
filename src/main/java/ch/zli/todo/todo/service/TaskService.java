package ch.zli.todo.todo.service;

import ch.zli.todo.todo.TaskRepository;
import ch.zli.todo.todo.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {this.taskRepository=taskRepository;}
    public Task createTask(Task task){return taskRepository.saveAndFlush(task);}
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    public void deleteTask(long id) { taskRepository.deleteById(id); }
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

}

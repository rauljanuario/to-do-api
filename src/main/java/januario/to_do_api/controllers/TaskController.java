package januario.to_do_api.controllers;

import januario.to_do_api.dto.response.TaskResponse;
import januario.to_do_api.models.Task;
import januario.to_do_api.models.User;
import januario.to_do_api.repositories.TaskRepository;
import januario.to_do_api.repositories.UserRepository;
import januario.to_do_api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<TaskResponse> getAll(){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return taskService.findAllByEmail(email)
                .stream()
                .map(TaskResponse::new)
                .toList();

    }

    @PostMapping("/create")
    public TaskResponse createTask (@RequestBody Task task){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        task.setUser(user); // Indentifica de quem é a tarefa

        Task saveTask = taskService.save(task);
        return new TaskResponse(saveTask);
    }

    @PutMapping("update/{id}")
    public TaskResponse updateTask (@PathVariable Long id, @RequestBody Task taskDetails){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Task task = taskService.findByIdAndEmail(id, email)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada ou acesso negado."));

        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());

        Task updateTask = taskService.save(task);
        return new TaskResponse(updateTask);

    }

    @DeleteMapping("{id}")
    public void deleteTask (@PathVariable Long id){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Task task = taskService.findByIdAndEmail(id, email)
                .orElseThrow(() -> new RuntimeException("Não autorizado para deletar essa tarefa."));

        taskService.delete(task.getId());

    }

}

package januario.to_do_api.services;

import januario.to_do_api.models.Task;
import januario.to_do_api.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllByEmail(String email){
        return taskRepository.findByUserEmail(email);
    }

    public Optional<Task> findByIdAndEmail(Long id, String email){
        return taskRepository.findByIdAndUserEmail(id, email);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

package januario.to_do_api.repositories;

import januario.to_do_api.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserEmail(String email);
    Optional<Task> findByIdAndUserEmail(Long id, String email);

}

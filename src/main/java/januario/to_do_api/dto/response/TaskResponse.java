package januario.to_do_api.dto.response;

import januario.to_do_api.models.Task;

public record TaskResponse(Long id, String description, boolean completed) {

    public TaskResponse (Task task){
        this(task.getId(), task.getDescription(), task.isCompleted());
    }

}

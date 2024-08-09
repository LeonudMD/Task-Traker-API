package leonud.md.task.traker.api.store.repositories;

import leonud.md.task.traker.api.store.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}

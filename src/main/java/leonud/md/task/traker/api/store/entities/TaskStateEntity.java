package leonud.md.task.traker.api.store.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "task_state")
public class TaskStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @OneToOne
    @JoinColumn(name = "left_task_state_id")
    TaskStateEntity leftTaskState;

    @OneToOne
    @JoinColumn(name = "right_task_state_id")
    TaskStateEntity rightTaskState;

    @Column(name = "created_at")
    @Builder.Default
    Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "project_id")
    ProjectEntity project;

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "task_state_id", referencedColumnName = "id")
    List<TaskEntity> tasks = new ArrayList<>();

    public Optional<TaskStateEntity> getLeftTaskState() {
        return Optional.ofNullable(leftTaskState);
    }

    public Optional<TaskStateEntity> getRightTaskState() {
        return Optional.ofNullable(rightTaskState);
    }
}
package leonud.md.task.traker.api.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "project")
@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "name", unique = true)
    String name;

    @Column(name = "updated_at")
    @Builder.Default
    Instant updatedAt = Instant.now();

    @Column(name = "created_at")
    @Builder.Default
    Instant createdAt = Instant.now();

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "project_id")
    List<TaskStateEntity> taskStates = new ArrayList<>();
}
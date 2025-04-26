package ge.never47.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo_items")
@Data
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @PrePersist
    protected void onCreate() {
        priority = 0;
    }
}
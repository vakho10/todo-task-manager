package ge.never47.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TodoItemRequestDTO(
        @NotBlank(message = "Title is required") String title,
        String description,
        boolean completed,
        LocalDateTime deadline
) {}
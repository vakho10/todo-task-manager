package ge.never47.taskmanager.dto;

import java.time.LocalDateTime;

public record TodoItemResponseDTO(Long id, String title, String description, boolean completed,
                                  LocalDateTime deadline) {
}
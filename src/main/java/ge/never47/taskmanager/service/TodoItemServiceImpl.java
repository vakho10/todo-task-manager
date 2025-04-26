package ge.never47.taskmanager.service;

import ge.never47.taskmanager.dto.TodoItemRequestDTO;
import ge.never47.taskmanager.dto.TodoItemResponseDTO;
import ge.never47.taskmanager.entity.TodoItem;
import ge.never47.taskmanager.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public TodoItemResponseDTO createTodoItem(TodoItemRequestDTO todoItemRequestDTO) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(todoItemRequestDTO.title());
        todoItem.setDescription(todoItemRequestDTO.description());
        todoItem.setCompleted(todoItemRequestDTO.completed());
        todoItem.setDeadline(todoItemRequestDTO.deadline());
        TodoItem savedItem = todoItemRepository.save(todoItem);
        return toResponseDTO(savedItem);
    }

    @Override
    public List<TodoItemResponseDTO> getAllTodoItems() {
        return todoItemRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TodoItemResponseDTO getTodoItemById(Long id) {
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo item not found"));
        return toResponseDTO(todoItem);
    }

    @Override
    public TodoItemResponseDTO updateTodoItem(Long id, TodoItemRequestDTO todoItemRequestDTO) {
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo item not found"));
        todoItem.setTitle(todoItemRequestDTO.title());
        todoItem.setDescription(todoItemRequestDTO.description());
        TodoItem updatedItem = todoItemRepository.save(todoItem);
        return toResponseDTO(updatedItem);
    }

    @Override
    public void deleteTodoItem(Long id) {
        todoItemRepository.deleteById(id);
    }

    private TodoItemResponseDTO toResponseDTO(TodoItem todoItem) {
        return new TodoItemResponseDTO(
                todoItem.getId(),
                todoItem.getTitle(),
                todoItem.getDescription(),
                todoItem.isCompleted(),
                todoItem.getDeadline()
        );
    }
}

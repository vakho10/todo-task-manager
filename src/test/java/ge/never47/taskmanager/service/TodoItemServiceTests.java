package ge.never47.taskmanager.service;

import ge.never47.taskmanager.dto.TodoItemRequestDTO;
import ge.never47.taskmanager.dto.TodoItemResponseDTO;
import ge.never47.taskmanager.entity.TodoItem;
import ge.never47.taskmanager.repository.TodoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TodoItemServiceTests {

    @Mock
    private TodoItemRepository todoItemRepository;

    @InjectMocks
    private TodoItemServiceImpl todoItemService;

    private TodoItem todoItem;
    private TodoItemRequestDTO todoItemRequestDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        todoItem = new TodoItem();
        todoItem.setId(1L);
        todoItem.setTitle("Test Title");
        todoItem.setDescription("Test Description");

        todoItemRequestDTO = new TodoItemRequestDTO(
                "Test Title", "Test Description", false, LocalDateTime.now());
    }

    @Test
    public void testCreateTodoItem() {
        when(todoItemRepository.save(any(TodoItem.class))).thenReturn(todoItem);
        TodoItemResponseDTO created = todoItemService.createTodoItem(todoItemRequestDTO);
        assertEquals("Test Title", created.title());
        verify(todoItemRepository, times(1)).save(any(TodoItem.class));
    }

    @Test
    public void testGetTodoItemById() {
        when(todoItemRepository.findById(1L)).thenReturn(Optional.of(todoItem));
        TodoItemResponseDTO found = todoItemService.getTodoItemById(1L);
        assertEquals("Test Title", found.title());
    }

    @Test
    public void testUpdateTodoItem() {
        when(todoItemRepository.findById(1L)).thenReturn(Optional.of(todoItem));
        when(todoItemRepository.save(any(TodoItem.class))).thenReturn(todoItem);
        TodoItemResponseDTO updated = todoItemService.updateTodoItem(1L, todoItemRequestDTO);
        assertEquals("Test Title", updated.title());
    }

    @Test
    public void testDeleteTodoItem() {
        todoItemService.deleteTodoItem(1L);
        verify(todoItemRepository, times(1)).deleteById(1L);
    }
}
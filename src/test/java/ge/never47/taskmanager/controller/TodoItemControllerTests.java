package ge.never47.taskmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.never47.taskmanager.dto.TodoItemRequestDTO;
import ge.never47.taskmanager.dto.TodoItemResponseDTO;
import ge.never47.taskmanager.service.TodoItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TodoItemControllerTests {

    private MockMvc mockMvc;

    @Mock
    private TodoItemService todoItemService;

    @InjectMocks
    private TodoItemController todoItemController;

    private TodoItemRequestDTO todoItemRequestDTO;
    private TodoItemResponseDTO todoItemResponseDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(todoItemController).build();

        // Setup mock data
        todoItemRequestDTO
                = new TodoItemRequestDTO("Test Title", "Test Description", false,
                LocalDateTime.now());
        todoItemResponseDTO
                = new TodoItemResponseDTO(1L, "Test Title", "Test Description", false,
                LocalDateTime.now());
    }

    @Test
    public void testCreateTodoItem() throws Exception {
        // Mock service layer call
        when(todoItemService.createTodoItem(any(TodoItemRequestDTO.class))).thenReturn(todoItemResponseDTO);

        // Perform POST request
        mockMvc.perform(post("/api/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todoItemRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.description").value("Test Description"));

        verify(todoItemService, times(1)).createTodoItem(any(TodoItemRequestDTO.class));
    }

    @Test
    public void testGetTodoItemById() throws Exception {
        // Mock service layer call
        when(todoItemService.getTodoItemById(1L)).thenReturn(todoItemResponseDTO);

        // Perform GET request
        mockMvc.perform(get("/api/todos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.description").value("Test Description"));

        verify(todoItemService, times(1)).getTodoItemById(1L);
    }

    @Test
    public void testGetAllTodoItems() throws Exception {
        // Mock service layer call
        when(todoItemService.getAllTodoItems()).thenReturn(List.of(todoItemResponseDTO));

        // Perform GET request
        mockMvc.perform(get("/api/todos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Test Title"))
                .andExpect(jsonPath("$[0].description").value("Test Description"));

        verify(todoItemService, times(1)).getAllTodoItems();
    }

    @Test
    public void testUpdateTodoItem() throws Exception {
        // Mock service layer call
        when(todoItemService.updateTodoItem(eq(1L), any(TodoItemRequestDTO.class)))
                .thenReturn(todoItemResponseDTO);

        // Perform PUT request
        mockMvc.perform(put("/api/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(todoItemRequestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.description").value("Test Description"));

        verify(todoItemService, times(1)).updateTodoItem(eq(1L), any(TodoItemRequestDTO.class));
    }

    @Test
    public void testDeleteTodoItem() throws Exception {
        // Perform DELETE request
        mockMvc.perform(delete("/api/todos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(todoItemService, times(1)).deleteTodoItem(1L);
    }

    // Helper method to convert object to JSON string
    private static String asJsonString(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

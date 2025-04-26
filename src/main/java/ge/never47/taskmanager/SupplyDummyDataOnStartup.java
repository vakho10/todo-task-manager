package ge.never47.taskmanager;

import ge.never47.taskmanager.dto.TodoItemRequestDTO;
import ge.never47.taskmanager.service.TodoItemService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplyDummyDataOnStartup {

    private final TodoItemService todoItemService;

    @SneakyThrows
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk", "I need to buy milk 3.2%"));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk 2", "I need to buy milk 3.2%"));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk 3", "I need to buy milk 3.2%"));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk 4", "I need to buy milk 3.2%"));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk 5", "I need to buy milk 3.2%"));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk 6", "I need to buy milk 3.2%"));
    }
}

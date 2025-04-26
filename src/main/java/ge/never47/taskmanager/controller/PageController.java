package ge.never47.taskmanager.controller;

import ge.never47.taskmanager.service.TodoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final TodoItemService todoItemService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoItemService.getAllTodoItems());
        return "index";
    }
}

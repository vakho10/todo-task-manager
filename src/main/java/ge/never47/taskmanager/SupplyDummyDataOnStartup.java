package ge.never47.taskmanager;

import ge.never47.taskmanager.dto.TodoItemRequestDTO;
import ge.never47.taskmanager.service.TodoItemService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class SupplyDummyDataOnStartup {

    private final TodoItemService todoItemService;
    private final Random random = new Random();

    @SneakyThrows
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // 50 Entries with random deadlines
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Milk", "I need to buy milk 3.2%", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Call Mom", "Remember to call mom in the evening.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Submit Tax Forms", "Submit all necessary documents before Friday.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Finish Homework", "Complete the math and science assignments.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Grocery Shopping", "Buy fruits, vegetables, and bread.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Workout", "Do a 30-minute workout session at the gym.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Read a Book", "Read at least 50 pages of 'Atomic Habits'.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Water Plants", "Water all indoor plants in the evening.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Pay Electricity Bill", "Pay the bill online before the due date.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Prepare Presentation", "Prepare slides for Monday's meeting.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Schedule Dentist Appointment", "Teeth cleaning appointment for next month.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Car Maintenance", "Change oil and check tire pressure.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Meal Prep", "Prepare meals for the next 3 days.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Plan Vacation", "Research places to visit and hotels.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Organize Desk", "Clean and reorganize office desk.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Update Resume", "Add recent experience and skills.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Fix Broken Shelf", "Buy nails and fix the broken shelf.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Order Birthday Gift", "Find a nice gift for Sarah.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Write Blog Post", "Write a new post about Java best practices.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Clean Garage", "Organize tools and sweep the floor.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Donate Old Clothes", "Drop off donation at local center.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Practice Guitar", "Practice scales and new song for 1 hour.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Update Software", "Update OS and all installed programs.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Dog Food", "Get the grain-free dog food from the pet store.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Organize Photos", "Sort and backup photos from the last trip.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Create Budget Plan", "Plan monthly expenses and savings.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Practice Meditation", "Do a 15-minute mindfulness session.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Clean Fridge", "Throw out expired food and wipe shelves.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Attend Webinar", "Join the cybersecurity webinar on Tuesday.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy Stationery", "Get pens, notebooks, and printer paper.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Fix Website Bug", "Resolve the 404 error on the contact page.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Study French", "Review vocabulary and practice speaking.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Backup Laptop", "Create a full backup of important files.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Pick Up Dry Cleaning", "Pick up clothes from the cleaners.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Paint Bedroom", "Buy paint and repaint bedroom walls.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Learn Spring Boot", "Finish chapter 5 of the Spring Boot course.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Review Pull Requests", "Review open PRs on the project repository.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Organize Bookshelf", "Sort books by genre and donate extras.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Buy New Laptop", "Research and buy a new laptop for work.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Plan Birthday Party", "Organize party details and guest list.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Declutter Email Inbox", "Unsubscribe from spam and clean inbox.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Go for a Hike", "Choose a nearby trail and hike this weekend.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Register for Marathon", "Sign up for the half marathon in October.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Make Doctor Appointment", "Routine annual checkup.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Update LinkedIn Profile", "Add recent projects and certifications.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Replace Light Bulbs", "Replace burnt-out bulbs in kitchen and hallway.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Write Thank You Cards", "Send cards to friends after party.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Watch Tutorial", "Watch tutorial on advanced Git techniques.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Pay Credit Card Bill", "Pay off balance before due date.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Book Hotel Room", "Reserve room for upcoming business trip.", random.nextBoolean(), getRandomDeadline()));
        todoItemService.createTodoItem(new TodoItemRequestDTO("Cook New Recipe", "Try cooking lasagna from scratch.", random.nextBoolean(), getRandomDeadline()));
    }

    // Method to generate a random deadline
    private LocalDateTime getRandomDeadline() {
        // Random number of days (1 to 30) and hours (0 to 23) for deadline
        int days = random.nextInt(30) + 1;
        int hours = random.nextInt(24);

        // Current time plus or minus random days and hours
        LocalDateTime time = LocalDateTime.now();
        if (random.nextBoolean()) {
            // Upcoming entries :)
            time = time.plusDays(days).plusHours(hours);
        } else {
            // Outdated entries :(
            time = time.minusDays(days).minusHours(hours);
        }
        return time;
    }
}

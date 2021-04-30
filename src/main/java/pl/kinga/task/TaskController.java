package pl.kinga.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


@Controller
public class TaskController {

    private TaskRepository taskRepository;
    private Scanner scanner;

    @Autowired
    public TaskController(Scanner scanner, TaskRepository taskRepository) {
        this.scanner = scanner;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public String home(Model model, Task task) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("tasks", allTasks);
        return "home";
    }

    @Transactional
    public String addNewTask(Model model) {
        Task task = readTask();
        taskRepository.save(task);
        System.out.println("Pomyślnie dodano zadanie");
        return "add";
    }

    private Task readTask() {
        Task task = new Task();
        Category category = null;
        System.out.println("Nazwa zadania:");
        task.setTaskName(scanner.nextLine());
        System.out.println("Czy wykonano: TRUE or FALSE");
        task.setDone(scanner.nextBoolean());
        System.out.println("Podaj termin wykonania:");
        task.setDeadline(LocalDate.parse(scanner.nextLine()));
        System.out.println("Kategoria zadania:");
        task.setCategory(category);
        scanner.nextLine();
        return task;
    }


//    //Wyswietla wszystkie wykonane zadania
//    List<Task> doneTasks = taskRepository.findByDoneTrue();
}


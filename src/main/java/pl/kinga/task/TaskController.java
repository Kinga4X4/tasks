package pl.kinga.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }


    @GetMapping("/home")
    @ResponseBody
    public String home(Model model, Task task) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("tasks", allTasks);
        return "home";
    }

    @GetMapping("/create")
    public String createView() {
        return "create";
    }

    @PostMapping
    public String create(Task task) {
        return "redirect";
    }

    @GetMapping("/createView")
    public String create() {
        return "create";
    }

//    @Transactional
//    public String addNewTask(Model model) {
//        Task task = readTask();
//        taskRepository.save(task);
//        System.out.println("Pomyślnie dodano zadanie");
//        return "add";
//    }

//    private Task readTask() {
//        Task task = new Task();
//        Category category;
//        System.out.println("Podaj nazwę zadania:");
//        task.setTaskName();
//        System.out.println("Czy zadanie zostało już wykonane: TRUE or FALSE");
//        task.setDone();
//        System.out.println("Podaj termin wykonania:");
//        task.setDeadline(LocalDate.parse());
//        System.out.println("Podaj kategorie zadania. Do wyboru:");
//        Category[] categories = Category.values();
//        for (Category category1 : categories) {
//            String name = category1.name();
//            System.out.println(name);
//        }
//        String category1 = ;
//        task.setCategory(Category.valueOf());
//        return task;
//    }


//    //Wyswietla wszystkie wykonane zadania
//    List<Task> doneTasks = taskRepository.findByDoneTrue();
}


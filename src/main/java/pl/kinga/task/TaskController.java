package pl.kinga.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {

    private TaskRepository taskRepository;
    private List<Task> tasks;

    @Autowired
    public TaskController(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/toDo")
    public String toDo(Model model) {
        List<Task> allTasks = taskRepository.findByDone(true);
        model.addAttribute("allTasks", allTasks);
        return "toDo";
    }

    @GetMapping("/done")
    public String done(Model model) {
        List<Task> doneTasks = taskRepository.findByDone(false);
        model.addAttribute("doneTasks", doneTasks);
        return "done";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        } else {
            return "toDo";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }
}


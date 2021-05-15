package pl.kinga.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/toDo")
    public String toDo(Model model) {
        List<Task> allTasks = taskRepository.findByDoneOrderByDeadlineAsc(false);
        model.addAttribute("allTasks", allTasks);
        return "toDo";
    }

    @GetMapping("/done")
    public String done(Model model) {
        List<Task> doneTasks = taskRepository.findByDoneOrderByDeadlineAsc(true);
        model.addAttribute("doneTasks", doneTasks);
        return "done";
    }

    @PostMapping("/save")
    public String postCreate(Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }

    @PostMapping("/checked/{id}")
    public String checked(@PathVariable Long id) {
        taskRepository.update(true, id);
        return "redirect:/";
    }
}


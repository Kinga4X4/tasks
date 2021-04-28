package pl.kinga.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public String home(Model model) {
        List<Task> allTasks = taskRepository.findAll();
        Task task = allTasks.get(1);
        taskRepository.save(task);
        model.addAttribute("tasks", allTasks);

        return "home";
    }
}

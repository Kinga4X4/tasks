package pl.kinga.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(Model model) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("tasks", allTasks);
        return "home";
    }

    private void find() {
        List<Task> doneTasks = taskRepository.findByDoneTrue();
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping
    public String create(Task task) {
        return "redirect";
    }

//    @GetMapping("/createView")
//    public String create() {
//        return "create";
//    }


}


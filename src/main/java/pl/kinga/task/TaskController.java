package pl.kinga.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String home(Model model) {
        List<Task> allTasks = taskRepository.findByDoneTrue();
        model.addAttribute("allTasks", allTasks);
        return "home";
    }

    @GetMapping("/done")
    public String home2(Model model) {
        List<Task> doneTasks = taskRepository.findByDoneFalse();
        model.addAttribute("doneTasks", doneTasks);
        return "home2";
    }


//    @PostMapping
//    public String addTask(@RequestBody Task task) {
//        return "create";
//    }
//

//    @PostMapping()
//    public String create(Task task) {
//        taskRepository.save(task);
//        return "redirect:/tasks";
//    }
//
//
//
//    private void find() {
//        List<Task> doneTasks = taskRepository.findByDoneTrue();
//    }
//
//    @GetMapping("/create")
//    public String create() {
//        return "create";
//    }
//
//
//
////    @GetMapping("/createView")
////    public String create() {
////        return "create";
////    }
//
//
}


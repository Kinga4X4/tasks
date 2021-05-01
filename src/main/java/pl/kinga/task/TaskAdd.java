package pl.kinga.task;

import org.springframework.ui.Model;

import javax.transaction.Transactional;

public class TaskAdd {

    TaskRepository taskRepository;

    @Transactional
    public String addNewTask(Model model) {
        System.out.println("Pomyślnie dodano zadanie");
        return "create";
    }

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

}

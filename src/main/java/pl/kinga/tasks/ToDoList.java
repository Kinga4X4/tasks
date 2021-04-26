package pl.kinga.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue
    private long id;
    private String taskName;
    private boolean done;
    private LocalDate deadline;

}

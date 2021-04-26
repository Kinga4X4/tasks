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

    ToDoList() {}

    public ToDoList(long id, String taskName, boolean done, LocalDate deadline) {
        this.id = id;
        this.taskName = taskName;
        this.done = done;
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return id + " " + taskName + " " + done + " " + deadline;
    }
}

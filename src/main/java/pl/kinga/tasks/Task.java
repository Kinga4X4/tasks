package pl.kinga.tasks;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @Column
    @Lob
    private String taskName;

    @Column
    private boolean done;

    @Column
    private LocalDate deadline;

    Task() {
    }

    public Task(long id, String taskName, boolean done, LocalDate deadline) {
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

package pl.kinga.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDoneOrderByDeadlineAsc(boolean b);

    @Transactional
    @Modifying
    @Query("update Task task set task.done = :done where task.id = :id")
    void update(@Param("done")boolean done, @Param ("id") Long id);

}

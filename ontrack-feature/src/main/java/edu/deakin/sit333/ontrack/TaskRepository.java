package edu.deakin.sit333.ontrack;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface – in real life this would hit the database.
 * In tests we supply a Mockito stub.
 */
public interface TaskRepository {

    /**
     * Return every task the given student has submitted.
     *
     * @param studentId  Deakin student ID
     * @return Optional.empty() if the student does not exist or has no tasks
     */
    Optional<List<TaskSummary>> findSubmittedTasksByStudent(String studentId);
}

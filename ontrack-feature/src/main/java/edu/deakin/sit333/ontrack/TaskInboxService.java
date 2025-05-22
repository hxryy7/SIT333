package edu.deakin.sit333.ontrack;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Returns all tasks a student has already submitted.
 * This is the feature you’ll document in your PDF report.
 */
public class TaskInboxService {

    private final TaskRepository repo;

    public TaskInboxService(TaskRepository repo) {
        this.repo = Objects.requireNonNull(repo);
    }

    /**
     * Get the student’s submitted tasks.
     *
     * @param studentId  must be non-blank
     * @return immutable list (possibly empty, never null)
     */
    public List<TaskSummary> getSubmittedTasks(String studentId) {
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("studentId must not be blank");
        }
        return repo.findSubmittedTasksByStudent(studentId)
                   .orElse(Collections.emptyList());
    }
}

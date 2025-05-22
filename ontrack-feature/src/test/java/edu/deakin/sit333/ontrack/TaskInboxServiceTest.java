package edu.deakin.sit333.ontrack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests written first (TDD) and run on JUnit 5.
 */
class TaskInboxServiceTest {

    @Test
    @DisplayName("Returns list when student has tasks")
    void inboxHasTasks() {
        // Arrange
        TaskRepository repo = mock(TaskRepository.class);
        List<TaskSummary> fake = List.of(
                new TaskSummary("T1", "SIT333", "Pass Task 9.1P", "Marked"),
                new TaskSummary("T2", "SIT330", "IR Indexing",     "In Progress"));
        when(repo.findSubmittedTasksByStudent("224234094"))
                .thenReturn(Optional.of(fake));

        TaskInboxService svc = new TaskInboxService(repo);

        // Act
        List<TaskSummary> actual = svc.getSubmittedTasks("224234094");

        // Assert
        assertEquals(2, actual.size());
        assertEquals("T1", actual.get(0).taskId());
        verify(repo).findSubmittedTasksByStudent("224234094");
    }

    @Test
    @DisplayName("Returns empty list when student has none")
    void inboxEmpty() {
        TaskRepository repo = mock(TaskRepository.class);
        when(repo.findSubmittedTasksByStudent("nobody"))
                .thenReturn(Optional.empty());

        TaskInboxService svc = new TaskInboxService(repo);

        assertTrue(svc.getSubmittedTasks("nobody").isEmpty());
    }

    @Test
    @DisplayName("Throws on blank studentId")
    void blankIdThrows() {
        TaskInboxService svc = new TaskInboxService(mock(TaskRepository.class));
        assertThrows(IllegalArgumentException.class,
                     () -> svc.getSubmittedTasks(" "));
    }
}

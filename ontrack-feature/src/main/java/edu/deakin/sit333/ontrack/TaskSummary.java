package edu.deakin.sit333.ontrack;

/** Lightweight view of a submitted task for the inbox list. */
public record TaskSummary(
        String taskId,
        String unitCode,
        String taskTitle,
        String status) { }

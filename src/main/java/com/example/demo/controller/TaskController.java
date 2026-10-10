package com.example.demo.controller;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskResponse;
import com.example.demo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    // Внедрение зависимости (Dependency Injection) через конструктор
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        // Передаем задачу в слой бизнес-логики
        var taskId = taskService.registerNewTask();

        // Быстро собираем ответ
        TaskResponse response = new TaskResponse(
                taskId,
                "queued",
                request.getUrls().size()
        );

        // Возвращаем статус 201 Created и JSON
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

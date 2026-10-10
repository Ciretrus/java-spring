package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service // Регистрируем компонент в контексте Spring
public class TaskService {

    public UUID registerNewTask() {
        // Имитируем регистрацию задачи в системе — генерируем UUID
        return UUID.randomUUID();
    }
}

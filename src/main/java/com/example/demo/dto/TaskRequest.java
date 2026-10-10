package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data // Аннотация Ломбока: сама создаст геттеры, сеттеры и toString
public class TaskRequest {
    private List<String> urls;
}

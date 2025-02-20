package com.java_lesson.demo.dto;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class ApiResponse<T> {
    private HttpStatusCode status;
    private String message;
    private T data;
}

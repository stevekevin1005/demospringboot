package com.java_lesson.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private String sex;
    private int weight;
    private int height;
    private boolean isDeleted = false;
    private Date createdAt;
    private Date updatedAt;
}

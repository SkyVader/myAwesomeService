package com.test.awesome.service;

import com.test.awesome.entity.DocumentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentDto {

    private Long id;

    private String name;
    private int number;
    private LocalDateTime createdAt;
    private DocumentStatus status;
    private String type;
    private String comment;
    private String description;
}

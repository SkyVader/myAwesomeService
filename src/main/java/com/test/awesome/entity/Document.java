package com.test.awesome.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Document {

    @Id
    private Long id;

    /**
     * Название документа
     */
    private String name;

    /**
     * Номер документа, не может быть изменен
     */
    private int number;

    /**
     * Дата документа, не может быть изменен
     */
    private LocalDateTime createdAt;

    /**
     * Статус документа
     */
    private DocumentStatus status;

    /**
     * Тип документа (заявление, жалоба и т.д.), не может быть изменен
     */
    private String type;

    private String comment;
    private String description;

    // for audit
    private String updatedUser;
    private LocalDateTime updatedAt;

}

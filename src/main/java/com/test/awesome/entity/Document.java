package com.test.awesome.entity;

import lombok.Data;

import javax.persistence.Column;
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
    @Column(nullable = false)
    private String name;

    /**
     * Номер документа, не может быть изменен
     */
    @Column(nullable = false)
    private int number;

    /**
     * Дата документа, не может быть изменен
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * Статус документа
     */
    @Column(nullable = false)
    private DocumentStatus status;

    /**
     * Тип документа (заявление, жалоба и т.д.), не может быть изменен
     */
    @Column(nullable = false)
    private String type;

    @Column
    private String comment;
    @Column
    private String description;

    // for audit
    private String updatedUser;
    private LocalDateTime updatedAt;

}

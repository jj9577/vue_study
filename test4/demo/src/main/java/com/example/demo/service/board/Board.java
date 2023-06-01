package com.example.demo.service.board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import com.example.demo.service.auditor.Auditor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor
public class Board extends Auditor<String> {
    
    @Id
    @SequenceGenerator(name = "BOARD_ID_SEQ", sequenceName = "BOARD_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOARD_ID_SEQ")
    private Long id;

    private String title;

    private String content;

    @Builder
    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

package com.example.demo.service.board;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDTO {
    
    @Id
    @SequenceGenerator(name = "BOARD_ID_SEQ", sequenceName = "BOARD_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOARD_ID_SEQ")
    private Long id;
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .build();
    }

    public BoardDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
package com.example.demo.controller.rest.apiresult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.service.board.Board;
import com.example.demo.service.board.BoardDTO;
import com.example.demo.service.board.BoardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardApiControllerTests {

    @Autowired
    private BoardService boardService;
    
    /* @AfterEach
    public void cleanup() {
        boardRepository.deleteAll();
    } */
    
   @Test
    public void testRead() throws Exception {
        Long id = Long.valueOf(1);
        boardService.view(id);
    }

    @Test
    public void testList() {
        List<Board> list = boardService.list();

        assertEquals(3, list.size());
    }

    @Test
    public void testSave() {
        BoardDTO boarddto = new BoardDTO();
        boarddto.setTitle("테스트 제목1");
        boarddto.setContent("테스트 본문1");

        BoardDTO result = boardService.post(boarddto);

        assertEquals("테스트 제목1", result.getTitle());
        assertEquals("테스트 본문1", result.getContent());
    }

    @Test
    public void testUpdate() throws Exception {

        List<Board> list = boardService.list();
        Long id = list.get(0).getId();

        BoardDTO boarddto = new BoardDTO();

        boarddto.setTitle("테스트 제목 수정 중22");
        boarddto.setContent("테스트 본문 수정 중22");
        
        BoardDTO result = boardService.update(boarddto, id);

        assertEquals("테스트 제목 수정 중22", result.getTitle());
        assertEquals("테스트 본문 수정 중22", result.getContent());
    }

    @Test
    public void testDelete() throws Exception {
        List<Board> list = boardService.list();
        Long id = list.get(0).getId();

        boardService.delete(id);
    }

}
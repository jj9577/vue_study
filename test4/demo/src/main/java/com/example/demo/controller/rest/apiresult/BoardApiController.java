package com.example.demo.controller.rest.apiresult;

import java.util.List;

import com.example.demo.controller.rest.ApiResult;
import com.example.demo.service.board.Board;
import com.example.demo.service.board.BoardDTO;
import com.example.demo.service.board.BoardService;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BoardApiController {

    BoardService boardService;

    @GetMapping("/api/boards")
    public ApiResult<List<Board>> getAll() {
        List<Board> list = boardService.list();

        return ApiResult.<List<Board>>builder()
                .data(list)
                .build();
    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") Long id) {
        ResponseEntity<?> entity = null;

        try {
            entity = new ResponseEntity<BoardDTO>(boardService.view(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @PostMapping("/api/boards/post")
    public ResponseEntity<?> create(@RequestBody final BoardDTO boarddto) {
        
        try {
            return new ResponseEntity<BoardDTO>(boardService.post(boarddto), HttpStatus.CREATED);
        } catch (final Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/api/boards/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BoardDTO boarddto) {
        try {
            return new ResponseEntity<BoardDTO>(boardService.update(boarddto, id), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/api/boards/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        
        ResponseEntity<?> entity = null;

        try {
            boardService.delete(id);
            entity = new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            entity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

}
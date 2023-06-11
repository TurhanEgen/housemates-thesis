package com.turhan.housemates.controller;

import com.turhan.housemates.model.entity.Board;
import com.turhan.housemates.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/{houseId}/boards")
public class BoardController {

    BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> gelAllBoard(@PathVariable String houseId){
        return new ResponseEntity<>(boardService.getAllBoard(houseId),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Board> createBoard(@PathVariable String houseId, @RequestBody Board board){
        return new ResponseEntity<>(boardService.createBoard(houseId,board), HttpStatus.CREATED);
    }

}

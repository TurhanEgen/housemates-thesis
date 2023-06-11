package com.turhan.housemates.service;

import com.turhan.housemates.model.entity.Board;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {

    Board createBoard(String houseId, Board board);

    List<Board> getAllBoard(String houseId);
}

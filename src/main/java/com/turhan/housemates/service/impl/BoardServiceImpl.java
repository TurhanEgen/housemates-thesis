package com.turhan.housemates.service.impl;

import com.turhan.housemates.model.entity.Board;
import com.turhan.housemates.model.entity.House;
import com.turhan.housemates.repository.BoardRepository;
import com.turhan.housemates.repository.HouseRepository;
import com.turhan.housemates.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    BoardRepository boardRepository;
    HouseRepository houseRepository;
    @Override
    public Board createBoard(String houseId,Board board) {

        House house = houseRepository.findHouseByHouseId(houseId);
        board.setHouseId(house.getHouseId());
        boardRepository.save(board);

        List<Board> boardList = house.getBoardList();
        boardList.add(board);
        house.setBoardList(boardList);

        houseRepository.save(house);

        return board;
    }

    @Override
    public List<Board> getAllBoard(String houseId) {

        House house = houseRepository.findHouseByHouseId(houseId);

        return house.getBoardList();
    }
}

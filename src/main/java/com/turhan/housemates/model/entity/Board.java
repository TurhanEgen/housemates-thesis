package com.turhan.housemates.model.entity;

import com.turhan.housemates.model.constants.BoardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "boards")
public class Board {

    @Id
    ObjectId boardId;

    String houseId;

    BoardType boardType;

}

package com.turhan.housemates.model.entity;

import com.turhan.housemates.model.entity.dto.UserHouseTransferDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "houses")
public class House {

    @Id
    private String houseId;

    private String houseName;

    @DocumentReference(lazy = true)
    private Adress adress;

    @DocumentReference()
    private List<Event> events;

    private List<UserHouseTransferDTO> housemates;

    @DocumentReference()
    private List<Board> boardList;

}

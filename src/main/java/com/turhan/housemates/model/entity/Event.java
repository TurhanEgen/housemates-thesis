package com.turhan.housemates.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turhan.housemates.model.entity.dto.UserHouseTransferDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    ObjectId eventId;

    String houseId;

    String description;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    Date start;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")// HH:mm:ss
    Date end;

    @DocumentReference(lazy = true)
    private List<UserHouseTransferDTO> participants;

    @DocumentReference(lazy = true)
    private Adress adress;

}

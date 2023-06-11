package com.turhan.housemates.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turhan.housemates.model.entity.Adress;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

public class EventTransferDTO {

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

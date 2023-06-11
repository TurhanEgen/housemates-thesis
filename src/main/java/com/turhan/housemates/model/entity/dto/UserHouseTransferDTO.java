package com.turhan.housemates.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class UserHouseTransferDTO {

    private ObjectId userId;
    private String userName;


}

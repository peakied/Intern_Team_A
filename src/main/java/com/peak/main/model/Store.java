package com.peak.main.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class Store {

    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private @MongoId ObjectId id;
    private String name;
    private ObjectId owner;
    private String detail;
    private String image;
}

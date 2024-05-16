package com.peak.main.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;


@Data
@Document
public class Item {
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private @MongoId ObjectId id;
    private String name;
    private Integer cost;
    private Integer discount;
    private ArrayList<String> image;
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId owner;
    private String category;
    private String detail;
    private ArrayList<String> type;
    private Integer stock;
    private Integer sold;
}

package com.peak.main.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Data
@Document
public class Coupon {

    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private @MongoId ObjectId id;
    private String name;
    private Integer discount;
    private ArrayList<String> requirement;
    private String image;

}

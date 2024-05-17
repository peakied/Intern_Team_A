package com.peak.main.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;


@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer cost;
    private Integer discount;
    @ElementCollection
    private ArrayList<String> image;
    @JsonSerialize(using= ToStringSerializer.class)
    private Long owner;
    private String category;
    private String detail;
    @ElementCollection
    private ArrayList<String> type;
    private Integer stock;
    private Integer sold;
}

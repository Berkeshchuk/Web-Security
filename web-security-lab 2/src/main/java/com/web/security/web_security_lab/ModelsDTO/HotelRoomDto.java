package com.web.security.web_security_lab.ModelsDTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HotelRoomDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private boolean available;
    private float area;
    private int rooms;
    private List<String> amenities;
}

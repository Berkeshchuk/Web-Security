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
    private Double price;
    private Boolean available;
    private Float area;
    private Integer rooms;
    private List<String> amenities;
}

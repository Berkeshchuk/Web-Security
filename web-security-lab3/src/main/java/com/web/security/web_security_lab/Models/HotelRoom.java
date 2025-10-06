package com.web.security.web_security_lab.Models;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.web.security.web_security_lab.Models.abstraction.ServiceItem;
import java.util.List;

import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel_rooms")
@SuperBuilder
@Data
@NoArgsConstructor
public class HotelRoom extends ServiceItem {
    @Column(nullable = false)
    private float area;
    @Column(nullable = false)
    private int rooms;

    @ElementCollection
    @Column(name = "amenitie")
    private List<String> amenities;
}

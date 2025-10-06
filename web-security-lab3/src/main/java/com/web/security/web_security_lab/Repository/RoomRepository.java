package com.web.security.web_security_lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.security.web_security_lab.Models.HotelRoom;

public interface RoomRepository extends JpaRepository<HotelRoom, Long> {
    
}

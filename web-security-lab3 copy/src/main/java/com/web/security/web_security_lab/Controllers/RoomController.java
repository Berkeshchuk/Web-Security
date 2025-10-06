package com.web.security.web_security_lab.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.security.web_security_lab.ModelsDTO.HotelRoomDto;
import com.web.security.web_security_lab.Services.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<?> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable(name = "id") long id){
        return roomService.getRoomById(id);
    }

    @PostMapping("/rooms/add_room")
    public ResponseEntity<?> addRoom(@RequestBody HotelRoomDto roomDto){
        return roomService.addRoom(roomDto);
    }

    @PutMapping("/rooms/update_room")
    public ResponseEntity<?> updateRoom(@RequestBody HotelRoomDto roomDto){
        return roomService.updateRoom(roomDto);
    }

    @DeleteMapping("/rooms/delete_room/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable(name = "id") long id){
        return roomService.deleteRoomById(id);
    }
}

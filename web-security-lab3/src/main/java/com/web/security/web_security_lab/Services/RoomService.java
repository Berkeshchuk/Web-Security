package com.web.security.web_security_lab.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.security.web_security_lab.DTOMappers.RoomMapper;
import com.web.security.web_security_lab.ModelsDTO.HotelRoomDto;
import com.web.security.web_security_lab.Repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public ResponseEntity<?> getAllRooms(){
        var rooms = roomRepository.findAll();
        var roomsDto = RoomMapper.INSTANCE.toListDTO(rooms);
        return ResponseEntity.ok(roomsDto);
    }
    public ResponseEntity<?> getRoomById(long id){
        var roomToFind = roomRepository.findById(id);
        if(roomToFind.isPresent()){
            var roomDto = RoomMapper.INSTANCE.toDTO(roomToFind.get());
            return ResponseEntity.ok(roomDto);
        }
        return ResponseEntity.badRequest().body("Кімнати із id: " + id + " немає");
    }

    public ResponseEntity<?> addRoom(HotelRoomDto roomDto){
        var room = RoomMapper.INSTANCE.toEntity(roomDto);
        try {
            roomRepository.save(room);
        } catch (Exception e) {
            e.printStackTrace();
           return ResponseEntity.internalServerError().body("При додаванні кімнати виникла помилка: " + e.getMessage());
        }

        return ResponseEntity.ok("Кімнату додано");
    }

    public ResponseEntity<?> updateRoom(HotelRoomDto roomDto){
        var roomToUpdate = roomRepository.findById(roomDto.getId());
        if(roomToUpdate.isPresent()){
            try {
                var updatedRoom = RoomMapper.INSTANCE.updateEntity(roomDto, roomToUpdate.get());
                roomRepository.save(updatedRoom);
                return ResponseEntity.ok(updatedRoom);
            } catch (Exception e) {
                 e.printStackTrace();
                return ResponseEntity.internalServerError().body("При оновленні кімнати виникла помилка: " + e.getMessage());
            }
        }

        return ResponseEntity.badRequest().body("Оновлення недоступне: в базі даних відсутня кімната з id: " + roomDto.getId());
    }

    public ResponseEntity<?> deleteRoomById(long id){
        var roomToDelete = roomRepository.findById(id);
        if(roomToDelete.isPresent()){
            try {
                roomRepository.deleteById(id);
                return ResponseEntity.ok("Кімнату із id: " + id + " успішно видалено");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().body("Помилка видалення: " + e.getMessage());
            }
        }

        return ResponseEntity.badRequest().body("Видалення недоступне: в базі даних відсутня кімната з id: " + id);
    }
}

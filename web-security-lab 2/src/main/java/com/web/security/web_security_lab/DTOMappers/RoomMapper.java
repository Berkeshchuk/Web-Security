package com.web.security.web_security_lab.DTOMappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.web.security.web_security_lab.Models.HotelRoom;
import com.web.security.web_security_lab.ModelsDTO.HotelRoomDto;

@Mapper
public interface RoomMapper {
    public static RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "available", source = "available")
    public HotelRoom toEntity(HotelRoomDto roomDto);
    @Mapping(target = "available", source = "available")
    public HotelRoomDto toDTO(HotelRoom room);
    @Mapping(target = "available", source = "available")
    public List<HotelRoomDto> toListDTO(List<HotelRoom> rooms);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public HotelRoom updateEntity(HotelRoomDto roomDto, @MappingTarget HotelRoom room);
}

package com.kantes.hotel.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kantes.hotel.model.Room;
import com.kantes.hotel.response.RoomResponse;
import com.kantes.hotel.service.IRoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    private final IRoomService roomService;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
        @RequestParam("photo") MultipartFile photo,
        @RequestParam("roomType") String roomType,
        @RequestParam("roomPrice") BigDecimal roomPrice

    ) throws SerialException, IOException, SQLException {
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());

        return ResponseEntity.ok(response);
    }


    @GetMapping("/room/types")
    public List <String> getRoomTypes() {        
        return roomService.getAllRoomTypes();
    }
    
}

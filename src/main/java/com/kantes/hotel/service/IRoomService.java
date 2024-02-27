package com.kantes.hotel.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.kantes.hotel.model.Room;


public interface IRoomService {

    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SerialException, SQLException;
    
}

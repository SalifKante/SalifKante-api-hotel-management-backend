package com.kantes.hotel.response;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.kantes.hotel.model.BookedRoom;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class RoomResponse {
    private Long id;

    
    private String roomType;
    private BigDecimal roomPrice;
    private Boolean isBooked = false;
    
    private String photo;
    
    private List<BookingResponse> bookings;
    
    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, Boolean isBooked, byte[] photoBytes,
            List<BookingResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice; 
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
        this.bookings = bookings;
    }
    
    
}

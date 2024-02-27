package com.kantes.hotel.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;
    private BigDecimal roomPrice;
    private Boolean isBooked = false;

    @Lob
    private Blob photo;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    //To Avoid null Exception Error after creating an instance of Room class
    public Room() {
        this.bookings = new ArrayList<>();
    }

    
    //Method to add booking in the list bookings
    public void addBooking(BookedRoom booking) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(booking);

        booking.setRoom(this);
        isBooked = true;

        //Generate the confirmation code after booking
        String bookingCode = RandomStringUtils.randomNumeric(10);

    }


}   

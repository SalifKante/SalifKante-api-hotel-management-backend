package com.kantes.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kantes.hotel.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
}

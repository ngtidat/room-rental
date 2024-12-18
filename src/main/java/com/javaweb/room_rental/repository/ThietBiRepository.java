package com.javaweb.room_rental.repository;

import com.javaweb.room_rental.entity.ThietBiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBiEntity, Long> {
}

package com.javaweb.room_rental.mapper;

import com.javaweb.room_rental.dto.ThietBiDTO;
import com.javaweb.room_rental.entity.ThietBiEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ThietBiMapper {
    public ThietBiDTO toDto(ThietBiEntity entity){
        if (entity == null) {
            return null;
        }
        ThietBiDTO res = new ThietBiDTO();
        res.setId(entity.getId());
        res.setTen(entity.getTen());
        res.setDonViTinh(entity.getDonViTinh());
        res.setHinhAnh(entity.getHinhAnh());
        res.setGhiChu(entity.getGhiChu());
        return res;
    }

    public ThietBiEntity toEntity(ThietBiDTO dto){
        if (dto == null) {
            return null;
        }
        ThietBiEntity res = new ThietBiEntity();
        res.setTen(dto.getTen());
        res.setDonViTinh(dto.getDonViTinh());
        res.setHinhAnh(dto.getHinhAnh());
        res.setGhiChu(dto.getGhiChu());
        res.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        res.setDelete(false);
        return res;
    }
}

package com.javaweb.room_rental.service;

import com.javaweb.room_rental.mapper.ThietBiMapper;
import com.javaweb.room_rental.dto.ThietBiDTO;
import com.javaweb.room_rental.entity.ThietBiEntity;
import com.javaweb.room_rental.repository.ThietBiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThietBiService {
    @Autowired
    private ThietBiRepository thietBiRepository;

    @Autowired
    private ThietBiMapper thietBiMapper;

    public List<ThietBiDTO> getAllThietBi(){
        List<ThietBiEntity> listThietBiEntity = thietBiRepository.findAll();
        return listThietBiEntity.stream()
                            .map(thietBiMapper::toDto)
                            .collect(Collectors.toList());
    }

    public ThietBiEntity insertThietBi(ThietBiDTO thietBiDTO){
        return thietBiRepository.save(thietBiMapper.toEntity(thietBiDTO));
    }

    public ThietBiEntity editThietBi(long id, ThietBiDTO thietBiDTO){
        ThietBiEntity thietBiEntity = thietBiRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Thiet bi không tồn tại với id: " + id)
        );

        thietBiEntity.setTen(thietBiDTO.getTen());
        thietBiEntity.setDonViTinh(thietBiDTO.getDonViTinh());
        thietBiEntity.setHinhAnh(thietBiDTO.getHinhAnh());
        thietBiEntity.setGhiChu(thietBiDTO.getGhiChu());

        return thietBiRepository.save(thietBiEntity);
    }

    public ThietBiDTO getThietBiById(long id){
        return thietBiRepository.findById(id).map(thietBiMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thiết bị với ID: " + id));
    }
}

package com.javaweb.room_rental.service;

import com.javaweb.room_rental.exception.AppException;
import com.javaweb.room_rental.exception.ErrorCode;
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
        List<ThietBiEntity> listThietBiEntity = thietBiRepository.findByIsDeleteNot(true);
        return listThietBiEntity.stream()
                            .map(thietBiMapper::toDto)
                            .collect(Collectors.toList());
    }

    public ThietBiEntity insertThietBi(ThietBiDTO thietBiDTO){
        return thietBiRepository.save(thietBiMapper.toEntity(thietBiDTO));
    }

    public ThietBiEntity editThietBi(long id, ThietBiDTO thietBiDTO){
        ThietBiEntity thietBiEntity = thietBiRepository.findById(id)
                .filter(entity -> !entity.getDelete())
                .orElseThrow(() -> new AppException(ErrorCode.DEVICE_NOT_EXISTED)
        );

        thietBiEntity.setTen(thietBiDTO.getTen());
        thietBiEntity.setDonViTinh(thietBiDTO.getDonViTinh());
        thietBiEntity.setHinhAnh(thietBiDTO.getHinhAnh());
        thietBiEntity.setGhiChu(thietBiDTO.getGhiChu());

        return thietBiRepository.save(thietBiEntity);
    }

    public void deleteThietBi(long id, ThietBiDTO thietBiDTO){
        ThietBiEntity thietBiEntity = thietBiRepository.findById(id)
                .filter(entity -> !entity.getDelete())
                .orElseThrow(() -> new AppException(ErrorCode.DEVICE_NOT_EXISTED)
        );

        thietBiEntity.setTen(thietBiDTO.getTen());
        thietBiEntity.setDonViTinh(thietBiDTO.getDonViTinh());
        thietBiEntity.setHinhAnh(thietBiDTO.getHinhAnh());
        thietBiEntity.setGhiChu(thietBiDTO.getGhiChu());
        thietBiEntity.setDelete(true);

        thietBiRepository.save(thietBiEntity);
    }

    public ThietBiDTO getThietBiById(long id){
        return thietBiRepository.findById(id)
                .filter(entity -> !entity.getDelete())
                .map(thietBiMapper::toDto)
                .orElseThrow(() -> new AppException(ErrorCode.DEVICE_NOT_EXISTED));
    }
}

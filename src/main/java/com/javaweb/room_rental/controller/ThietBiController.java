package com.javaweb.room_rental.controller;

import com.javaweb.room_rental.dto.ApiResponse;
import com.javaweb.room_rental.dto.ThietBiDTO;
import com.javaweb.room_rental.entity.ThietBiEntity;
import com.javaweb.room_rental.service.ThietBiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class ThietBiController {
    @Autowired
    private ThietBiService thietBiService;

    @PostMapping("/thiet-bi/tao-moi")
    public ApiResponse<ThietBiEntity> createThietBi(@Valid @RequestBody ThietBiDTO request){
        ApiResponse<ThietBiEntity> apiResponse = new ApiResponse<>();
        apiResponse.setResult(thietBiService.insertThietBi(request));
        return apiResponse;
    }

    @GetMapping("/thiet-bi/danh-sach")
    public ApiResponse<List<ThietBiDTO>> listThietBi(){
        ApiResponse<List<ThietBiDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(thietBiService.getAllThietBi());
        return apiResponse;
    }

    @GetMapping("/thiet-bi/{thiet-bi-id}")
    public ApiResponse<ThietBiDTO> getThietBiById(@PathVariable("thiet-bi-id") long id){
        ApiResponse<ThietBiDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(thietBiService.getThietBiById(id));
        return apiResponse;
    }

    @PutMapping("/thiet-bi/chinh-sua/{thiet-bi-id}")
    public ApiResponse<ThietBiEntity> editThietBi(@PathVariable("thiet-bi-id") long thietBiID, @Valid @RequestBody ThietBiDTO thietBiDTO) {
        ApiResponse<ThietBiEntity> apiResponse = new ApiResponse<>();
        apiResponse.setResult(thietBiService.editThietBi(thietBiID, thietBiDTO));
        return apiResponse;
    }

    @PutMapping("/thiet-bi/xoa/{thiet-bi-id}")
    public ApiResponse<String> xoaThietBi(@PathVariable("thiet-bi-id") long thietBiID, @Valid @RequestBody ThietBiDTO thietBiDTO) {
        thietBiService.deleteThietBi(thietBiID, thietBiDTO);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("The device was deleted");
        return apiResponse;
    }
}

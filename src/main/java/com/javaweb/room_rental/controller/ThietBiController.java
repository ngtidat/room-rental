package com.javaweb.room_rental.controller;

import com.javaweb.room_rental.dto.ThietBiDTO;
import com.javaweb.room_rental.entity.ThietBiEntity;
import com.javaweb.room_rental.service.ThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class ThietBiController {
    @Autowired
    private ThietBiService thietBiService;

    @PostMapping("/thiet-bi/tao-moi")
    public ThietBiEntity createThietBi(@RequestBody ThietBiDTO request){
        return thietBiService.insertThietBi(request);
    }

    @GetMapping("/thiet-bi/danh-sach")
    public List<ThietBiDTO> listThietBi(){
        return thietBiService.getAllThietBi();
    }

    @GetMapping("/thiet-bi/{thiet-bi-id}")
    public ThietBiDTO getThietBiById(@PathVariable("thiet-bi-id") long id){
        return thietBiService.getThietBiById(id);
    }

    @PutMapping("/thiet-bi/chinh-sua/{thiet-bi-id}")
    public ThietBiEntity editThietBi(@PathVariable("thiet-bi-id") long thietBiID, @RequestBody ThietBiDTO thietBiDTO) {
        return thietBiService.editThietBi(thietBiID, thietBiDTO);
    }
}

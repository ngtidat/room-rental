package com.javaweb.room_rental.dto;

import com.javaweb.room_rental.exception.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ThietBiDTO {
    private long id;
    @NotBlank(message = "NAME_DEVICE_INVALID")
    private String ten;
    @NotBlank(message = "UNIT_DEVICE_INVALID")
    private String donViTinh;
    @NotBlank(message = "IMAGE_DEVICE_INVALID")
    private String hinhAnh;
    @NotBlank(message = "DESC_DEVICE_INVALID")
    private String ghiChu;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}

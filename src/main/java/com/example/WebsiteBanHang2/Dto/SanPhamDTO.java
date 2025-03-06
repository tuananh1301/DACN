package com.example.WebsiteBanHang2.Dto;

import com.example.WebsiteBanHang2.Model.DanhMuc;
import lombok.Data;

@Data
public class SanPhamDTO {
    private Integer id;
    private DanhMuc idDanhMuc;
    private String tenSanPham;
    private String maSanPham;
    private String moTa;
    private Byte trangThai;


}

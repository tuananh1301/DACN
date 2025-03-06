package com.example.WebsiteBanHang2.Dto;

import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class HoaDonChiTietDTO {
    private Integer id;
    private HoaDon hoaDon; // Thay Integer hoaDonId bằng HoaDonDTO
    private SanPhamChiTiet sanPhamChiTietId; // Giữ Integer nếu chỉ cần ID
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;
    private Byte trangThai;

}
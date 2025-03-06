package com.example.WebsiteBanHang2.Model.GioHang;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CartItem {
    private Integer sanPhamChiTietId;
    private String tenSanPham;
    private Integer soLuongMua;
    private BigDecimal donGia;

    public CartItem(Integer id, String tenSanPham, Integer soLuongMua, BigDecimal donGia) {
        this.sanPhamChiTietId = id;
        this.tenSanPham = tenSanPham;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
    }

    public BigDecimal getThanhTien() {
        return donGia.multiply(BigDecimal.valueOf(soLuongMua));
    }
}

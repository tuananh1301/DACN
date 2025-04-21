package com.example.WebsiteBanHang2.Model.GioHang;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CartItem {
    private Integer sanPhamChiTietId;
    private String tenSanPham;
    private Integer soLuongMua;
    private BigDecimal donGia;
    private String mauSac;
    private String kichThuoc;
    private String photo;
    private String formattedDonGia;
    private String formattedThanhTien;

    public CartItem(Integer sanPhamChiTietId, String tenSanPham, Integer soLuongMua, BigDecimal donGia,
                    String mauSac, String kichThuoc, String photo) {
        this.sanPhamChiTietId = sanPhamChiTietId;
        this.tenSanPham = tenSanPham;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.photo = photo;
    }

    public BigDecimal getThanhTien() {
        return donGia.multiply(BigDecimal.valueOf(soLuongMua));
    }
}

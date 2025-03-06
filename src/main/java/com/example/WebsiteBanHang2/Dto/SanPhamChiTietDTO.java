package com.example.WebsiteBanHang2.Dto;

import com.example.WebsiteBanHang2.Model.ThietKe;
import com.example.WebsiteBanHang2.Model.ThuongHieu;
import com.example.WebsiteBanHang2.Model.SanPham;
import com.example.WebsiteBanHang2.Model.KichThuoc;
import com.example.WebsiteBanHang2.Model.MauSac;
import com.example.WebsiteBanHang2.Model.ChatLieu;
import com.example.WebsiteBanHang2.Model.KieuDang;
import com.example.WebsiteBanHang2.Model.CoAo;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
public class SanPhamChiTietDTO {
    private Integer id;
    private SanPham sanPhamId;
    private KichThuoc kichThuocId;
    private MauSac mauSacId;
    private ChatLieu chatLieuId;
    private KieuDang kieuDangId;
    private CoAo coAoId;
    private ThietKe thietKeId;
    private ThuongHieu thuongHieuId;
    private Integer soLuong;
    private BigDecimal donGia;
    private LocalDate ngayTao;
    private LocalDate ngayCapNhat;
    private String nguoiCapNhat;
    private Byte trangThai;
}

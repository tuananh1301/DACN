package com.example.WebsiteBanHang2.Dto;

import com.example.WebsiteBanHang2.Model.DonViVanChuyen;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.UserAccount;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class HoaDonDTO {
    private Integer id;
    private UserAccount idKhachHang;
    private String maHoaDon;
    private String loaiDon;
    private String diaChiGiaoHang;
    private BigDecimal tongTien;
    private DonViVanChuyen idDonViVanChuyen;
    private HoaDon.TrangThaiVanChuyen trangThaiVanChuyen;
    private LocalDate ngayTao;
    private Byte trangThai;

}

package com.example.WebsiteBanHang2.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private UserAccount idKhachHang;

    @Column(name = "ma_hoa_don")
    private String maHoaDon;

    @Column(name = "loai_don")
    private String loaiDon;

    @Column(name = "dia_chi_giao_hang")
    private String diaChiGiaoHang;

    @Column(name = "tong_tien")
    private BigDecimal tongTien;

    @ManyToOne
    @JoinColumn(name = "id_don_vi_van_chuyen")
    private DonViVanChuyen idDonViVanChuyen;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_van_chuyen")
    private TrangThaiVanChuyen trangThaiVanChuyen;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "trang_thai")
    private Byte trangThai;
    public enum TrangThaiVanChuyen {
        PENDING, SHIPPED, DELIVERED, CANCELLED, COMPLETED
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "id=" + id +
                ", maHoaDon='" + maHoaDon + '\'' +
                ", loaiDon='" + loaiDon + '\'' +
                ", diaChiGiaoHang='" + diaChiGiaoHang + '\'' +
                ", tongTien=" + tongTien +
                ", trangThaiVanChuyen=" + trangThaiVanChuyen +
                ", ngayTao=" + ngayTao +
                ", trangThai=" + trangThai +
                '}';
    }
}

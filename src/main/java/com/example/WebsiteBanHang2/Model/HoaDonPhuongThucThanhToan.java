package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "hoa_don_phuong_thuc_thanh_toan")
public class HoaDonPhuongThucThanhToan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    private HoaDon hoaDonId;
    @ManyToOne
    @JoinColumn(name = "phuong_thuc_thanh_toan_id")
    private PhuongThucThanhToan phuongThucThanhToanId;

    @Column(name = "so_tien_thanh_toan")
    private BigDecimal soTienThanhToan;

    @Column(name = "ngay_thuc_hien_thanh_toan")
    private LocalDate ngayThucHienThanhToan;

    @Column(name = "ghi_chu")
    private String ghiChu;


}

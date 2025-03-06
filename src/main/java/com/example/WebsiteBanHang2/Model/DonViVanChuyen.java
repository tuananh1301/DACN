package com.example.WebsiteBanHang2.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "don_vi_van_chuyen")
public class DonViVanChuyen {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_don_vi")
    private String tenDonVi;

    @Column(name = "phi_van_chuyen")
    private BigDecimal phiVanChuyen;

    @Column(name = "ma_don_vi")
    private String maDonVi;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

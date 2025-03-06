package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc idDanhMuc;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "ma_san_pham")
    private String maSanPham;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

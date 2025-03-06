package com.example.WebsiteBanHang2.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "kieu_dang")
public class KieuDang {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_kieu_dang")
    private String maKieuDang;

    @Column(name = "ten_kieu_dang")
    private String tenKieuDang;

    @Column(name = "trang_thai")
    private Byte trangThai;

}

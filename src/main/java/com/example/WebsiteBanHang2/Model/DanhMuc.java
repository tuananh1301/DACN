package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "danh_muc")
public class DanhMuc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_danh_muc")
    private String maDanhMuc;

    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

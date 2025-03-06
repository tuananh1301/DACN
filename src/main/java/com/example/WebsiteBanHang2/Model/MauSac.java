package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mau_sac")
public class MauSac {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_mau_sac")
    private String maMauSac;

    @Column(name = "ten_mau_sac")
    private String tenMauSac;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

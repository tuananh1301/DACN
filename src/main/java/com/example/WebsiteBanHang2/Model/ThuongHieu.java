package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "thuong_hieu")
public class ThuongHieu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_thuong_hieu")
    private String maThuongHieu;

    @Column(name = "ten_thuong_hieu")
    private String tenThuongHieu;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

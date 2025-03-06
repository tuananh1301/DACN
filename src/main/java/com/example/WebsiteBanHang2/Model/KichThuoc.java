package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "kich_thuoc")
public class KichThuoc {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_kich_thuoc")
    private String maKichThuoc;

    @Column(name = "ten_kich_thuoc")
    private String tenKichThuoc;

    @Column(name = "trang_thai")
    private Byte trangThai;

}

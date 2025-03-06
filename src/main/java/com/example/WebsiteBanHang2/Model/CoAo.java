package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table (name = "co_ao")
public class CoAo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_co_ao")
    private String maCoAo;

    @Column(name = "ten_co_ao")
    private String tenCoAo;

    @Column(name = "trang_thai")
    private Byte trangThai;

}

package com.example.WebsiteBanHang2.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "thiet_ke")
public class ThietKe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_thiet_ke")
    private String maThietKe;

    @Column(name = "ten_thiet_ke")
    private String tenThietKe;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

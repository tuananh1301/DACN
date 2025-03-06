package com.example.WebsiteBanHang2.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "san_pham_chi_tiet")
public class SanPhamChiTiet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPhamId;
    @ManyToOne
    @JoinColumn(name = "kich_thuoc_id")
    private KichThuoc kichThuocId;
    @ManyToOne
    @JoinColumn(name = "mau_sac_id")
    private MauSac mauSacId;
    @ManyToOne
    @JoinColumn(name = "chat_lieu_id")
    private ChatLieu chatLieuId;
    @ManyToOne
    @JoinColumn(name = "kieu_dang_id")
    private KieuDang kieuDangId;
    @ManyToOne
    @JoinColumn(name = "co_ao_id")
    private CoAo coAoId;
    @ManyToOne
    @JoinColumn(name = "thiet_ke_id")
    private ThietKe thietKeId;
    @ManyToOne
    @JoinColumn(name = "thuong_hieu_id")
    private ThuongHieu thuongHieuId;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    private BigDecimal donGia;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "nguoi_cap_nhat")
    private String nguoiCapNhat;

    @Column(name = "trang_thai")
    private Byte trangThai;

}

package com.example.WebsiteBanHang2.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DonViVanChuyenDTO {
    private Integer id;
    private String tenDonVi;
    private String maDonVi;
    private BigDecimal phiVanChuyen;
    private Byte trangThai;

}

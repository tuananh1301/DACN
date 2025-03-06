package com.example.WebsiteBanHang2.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
@Data
public class HoaDonPhuongThucThanhToanDTO {
    private Integer id;
    private Integer hoaDonId;
    private Integer phuongThucThanhToanId;
    private BigDecimal soTienThanhToan;
    private LocalDate ngayThucHienThanhToan;
    private String ghiChu;

}

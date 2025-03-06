package com.example.WebsiteBanHang2.Dto;

import lombok.Data;

@Data
public class PhuongThucThanhToanDTO {
    private Integer id;
    private String maPhuongThuc;
    private String tenPhuongThuc;
    private String ghiChu;
    private Byte trangThai;

}

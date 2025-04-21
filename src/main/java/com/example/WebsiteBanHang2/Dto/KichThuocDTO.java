package com.example.WebsiteBanHang2.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KichThuocDTO {
    private Integer id;
    private String maKichThuoc;
    private String tenKichThuoc;
    private Byte trangThai;

}

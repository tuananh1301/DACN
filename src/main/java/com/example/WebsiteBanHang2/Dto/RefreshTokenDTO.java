package com.example.WebsiteBanHang2.Dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
@Data
public class RefreshTokenDTO {
    private Integer id;
    private Integer userId;
    private String token;
    private LocalDate expiryDate;

}

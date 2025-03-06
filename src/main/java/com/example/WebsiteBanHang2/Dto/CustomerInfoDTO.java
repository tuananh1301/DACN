package com.example.WebsiteBanHang2.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CustomerInfoDTO {
    private Integer id;
    private Integer userId;
    private String phone;
    private LocalDate birthDate;
    private String address;

}

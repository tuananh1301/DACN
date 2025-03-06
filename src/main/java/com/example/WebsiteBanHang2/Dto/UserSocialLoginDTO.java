package com.example.WebsiteBanHang2.Dto;

import com.example.WebsiteBanHang2.Model.UserAccount;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserSocialLoginDTO {
    private Integer id;
    private UserAccount userId;
    private String provider;
    private String socialId;
    private String email;
    private LocalDate createdAt;

}

package com.example.WebsiteBanHang2.Dto;

import com.example.WebsiteBanHang2.Model.UserAccount;
import lombok.Data;

@Data
public class StaffInfoDTO {
    private Integer id;
    private UserAccount userId;
    private String staffCode;
    private String department;


}

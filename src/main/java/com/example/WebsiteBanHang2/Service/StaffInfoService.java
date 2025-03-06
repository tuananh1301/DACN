package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.StaffInfoDTO;
import com.example.WebsiteBanHang2.Dto.StaffInfoDTO;

import java.util.List;

public interface StaffInfoService {
    List<StaffInfoDTO> getList();
    StaffInfoDTO getStaffInfoById(Integer id);
    StaffInfoDTO createEndUpdateStaffInfo(StaffInfoDTO staffInfoDTO);
    void deleteStaffInfo(Integer id);
}

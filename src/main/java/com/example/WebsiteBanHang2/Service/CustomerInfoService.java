package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.CustomerInfoDTO;

import java.util.List;

public interface CustomerInfoService {
    List<CustomerInfoDTO> getList();
    CustomerInfoDTO getCustomerInfoById(Integer id);
    CustomerInfoDTO createEndUpdateCustomerInfo(CustomerInfoDTO customerInfoDTO);
    void deleteCustomerInfo(Integer id);
}

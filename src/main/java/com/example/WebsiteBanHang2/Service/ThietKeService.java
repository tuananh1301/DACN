package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ThietKeDTO;
import com.example.WebsiteBanHang2.Dto.ThietKeDTO;

import java.util.List;

public interface ThietKeService {
    List<ThietKeDTO> getList();
    ThietKeDTO getThietKeById(Integer id);
    ThietKeDTO createEndUpdateThietKe(ThietKeDTO thietKeDTO);
    void deleteThietKe(Integer id);
}

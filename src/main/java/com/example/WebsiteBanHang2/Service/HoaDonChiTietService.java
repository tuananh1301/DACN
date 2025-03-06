package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.HoaDonChiTietDTO;
import com.example.WebsiteBanHang2.Model.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietService {
    List<HoaDonChiTietDTO> getList();
    HoaDonChiTietDTO getHoaDonChiTietById(Integer id);
    HoaDonChiTietDTO createEndUpdateHoaDonChiTiet(HoaDonChiTietDTO hoaDonChiTietDTO);
    List<HoaDonChiTiet> findByHoaDonId(Integer hoaDonId);
    void deleteHoaDonChiTiet(Integer id);
}

package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;
import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;

import java.util.List;

public interface SanPhamChiTietService {
    List<SanPhamChiTietDTO> getListDTO();
    List<SanPhamChiTiet> getList();
    SanPhamChiTietDTO getSanPhamChiTietById(Integer id);
    SanPhamChiTietDTO createEndUpdateSanPhamChiTiet(SanPhamChiTietDTO sanPhamChiTietDTO);
    void deleteSanPhamChiTiet(Integer id);
}

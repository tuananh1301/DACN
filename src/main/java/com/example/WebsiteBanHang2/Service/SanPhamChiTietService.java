package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;
import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import com.mysql.cj.log.Log;

import java.util.List;

public interface SanPhamChiTietService {
    List<SanPhamChiTietDTO> getListDTO();
    List<SanPhamChiTiet> getList();
    SanPhamChiTietDTO getSanPhamChiTietById(Integer id);
    SanPhamChiTietDTO createEndUpdateSanPhamChiTiet(SanPhamChiTietDTO sanPhamChiTietDTO);
    void deleteSanPhamChiTiet(Integer id);
    SanPhamChiTiet findSanPhamChiTietById(Integer id);
    List<SanPhamChiTiet> getBySanPham();
    List<String> getKichThuocBySanPham(Integer sanPhamId);
    List<String> getMauSacBySanPham(Integer sanPhamId);
    Integer findSoLuongBySanPhamChiTiet(Integer id);
}

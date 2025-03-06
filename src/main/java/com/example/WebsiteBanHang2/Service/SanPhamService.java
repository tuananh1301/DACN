package com.example.WebsiteBanHang2.Service;
import com.example.WebsiteBanHang2.Dto.SanPhamDTO;

import java.util.List;

public interface SanPhamService {
    List<SanPhamDTO> getList();
    SanPhamDTO getSanPhamDTOById(Integer id);
    SanPhamDTO createEndUpdateSanPhamDTO(SanPhamDTO sanPham);
    void deleteSanPhamDTO(Integer id);
}

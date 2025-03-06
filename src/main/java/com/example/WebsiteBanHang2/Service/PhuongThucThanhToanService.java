package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.PhuongThucThanhToanDTO;

import java.util.List;
public interface PhuongThucThanhToanService {
    List<PhuongThucThanhToanDTO> getList();
    PhuongThucThanhToanDTO getPhuongThucThanhToanById(Integer id);
    PhuongThucThanhToanDTO createEndUpdatePhuongThucThanhToan(PhuongThucThanhToanDTO phuongThucThanhToanDTO);
    void deletePhuongThucThanhToan(Integer id);
}

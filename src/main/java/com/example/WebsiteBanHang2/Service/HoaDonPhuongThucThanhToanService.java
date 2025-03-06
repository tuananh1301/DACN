package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.HoaDonPhuongThucThanhToanDTO;

import java.util.List;

public interface HoaDonPhuongThucThanhToanService {
    List<HoaDonPhuongThucThanhToanDTO> getList();
    HoaDonPhuongThucThanhToanDTO getHoaDonPhuongThucThanhToanById(Integer id);
    HoaDonPhuongThucThanhToanDTO createEndUpdateHoaDonPhuongThucThanhToan(HoaDonPhuongThucThanhToanDTO hoaDonPhuongThucThanhToanDTO);
    void deleteHoaDonPhuongThucThanhToan(Integer id);
}

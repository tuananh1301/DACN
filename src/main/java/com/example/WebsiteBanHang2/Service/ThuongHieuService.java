package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;
import com.example.WebsiteBanHang2.Dto.ThuongHieuDTO;

import java.util.List;

public interface ThuongHieuService {
    List<ThuongHieuDTO> getList();
    ThuongHieuDTO getThuongHieuById(Integer id);
    ThuongHieuDTO createEndUpdateThuongHieu(ThuongHieuDTO thuongHieuDTO);
    void deleteThuongHieu(Integer id);
}

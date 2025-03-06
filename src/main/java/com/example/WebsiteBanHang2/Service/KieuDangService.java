package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.KieuDangDTO;
import com.example.WebsiteBanHang2.Model.KieuDang;

import java.util.List;

public interface KieuDangService {
    List<KieuDang> getList();
    List<KieuDangDTO> getListDTO();
    KieuDangDTO getKieuDangById(Integer id);
    KieuDangDTO createEndUpdateKieuDang(KieuDangDTO kieuDangDTO);
    void deleteKieuDang(Integer id);
}

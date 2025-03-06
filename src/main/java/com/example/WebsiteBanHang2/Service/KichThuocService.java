package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.KichThuocDTO;

import java.util.List;

public interface KichThuocService {
    List<KichThuocDTO> getList();
    KichThuocDTO getKichThuocById(Integer id);
    KichThuocDTO createEndUpdateKichThuoc(KichThuocDTO kichThuocDTO);
    void deleteKichThuoc(Integer id);
}

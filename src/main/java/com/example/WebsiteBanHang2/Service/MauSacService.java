package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.MauSacDTO;

import java.util.List;

public interface MauSacService {
    List<MauSacDTO> getList();
    MauSacDTO getMauSacById(Integer id);
    MauSacDTO createEndUpdateMauSac(MauSacDTO mauSacDTO);
    void deleteMauSac(Integer id);
}

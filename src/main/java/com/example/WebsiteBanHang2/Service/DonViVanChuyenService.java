package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.DonViVanChuyenDTO;

import java.util.List;

public interface DonViVanChuyenService {
    List<DonViVanChuyenDTO> getList();
    DonViVanChuyenDTO getDonViVanChuyenById(Integer id);
    DonViVanChuyenDTO createEndUpdateDonViVanChuyen(DonViVanChuyenDTO donViVanChuyenDTO);
    void deleteDonViVanChuyen(Integer id);
}

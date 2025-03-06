package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.DanhMucDTO;

import java.util.List;

public interface DanhMucService {
    List<DanhMucDTO> getList();
    DanhMucDTO getDanhMucById(Integer id);
    DanhMucDTO createEndUpdateDanhMuc(DanhMucDTO danhMucDTO);
    void deleteDanhMuc(Integer id);
}

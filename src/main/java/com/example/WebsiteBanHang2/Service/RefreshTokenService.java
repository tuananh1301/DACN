package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;

import java.util.List;

public interface RefreshTokenService {
    List<RefreshTokenDTO> getList();
    RefreshTokenDTO getRefreshTokenById(Integer id);
    RefreshTokenDTO createEndUpdateRefreshToken(RefreshTokenDTO refreshTokenDTO);
    void deleteRefreshToken(Integer id);
}

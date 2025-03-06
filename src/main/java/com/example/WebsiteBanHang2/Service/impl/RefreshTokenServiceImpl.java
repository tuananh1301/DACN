package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;
import com.example.WebsiteBanHang2.Model.RefreshToken;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Repository.RefreshTokenRepository;
import com.example.WebsiteBanHang2.Service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private RefreshTokenDTO convertToDto(RefreshToken refreshToken) {
        RefreshTokenDTO refreshTokenDTO = new RefreshTokenDTO();
        refreshTokenDTO.setId(refreshToken.getId());
        refreshTokenDTO.setUserId(refreshToken.getUserId().getId());
        refreshTokenDTO.setToken(refreshToken.getToken());
        refreshTokenDTO.setExpiryDate(refreshToken.getExpiryDate());
        refreshTokenDTO.setUserId(refreshToken.getUserId().getId());
        return refreshTokenDTO;
    }

    private RefreshToken convertToEntity(RefreshTokenDTO refreshTokenDTO) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setId(refreshTokenDTO.getId());
        refreshToken.setToken(refreshTokenDTO.getToken());
        refreshToken.setExpiryDate(refreshTokenDTO.getExpiryDate());
        UserAccount userAccount = new UserAccount();
        userAccount.setId(refreshTokenDTO.getUserId());
        refreshToken.setUserId(userAccount);
        return refreshToken;
    }

    @Override
    public List<RefreshTokenDTO> getList() {
        List<RefreshToken> refreshTokenList = refreshTokenRepository.findAll();
        return refreshTokenList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RefreshTokenDTO getRefreshTokenById(Integer id) {
        RefreshToken refreshToken = refreshTokenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refresh token không tồn tại với ID: " + id));
        return convertToDto(refreshToken);
    }

    @Override
    public RefreshTokenDTO createEndUpdateRefreshToken(RefreshTokenDTO refreshTokenDTO) {
        RefreshToken refreshToken = convertToEntity(refreshTokenDTO);
        RefreshToken refreshTokenSaved = refreshTokenRepository.save(refreshToken);
        return convertToDto(refreshTokenSaved);
    }

    @Override
    public void deleteRefreshToken(Integer id) {
        RefreshToken refreshToken = refreshTokenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refresh token không tồn tại với ID: " + id));
        refreshTokenRepository.delete(refreshToken);
    }
}
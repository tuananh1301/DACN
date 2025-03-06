package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;
import com.example.WebsiteBanHang2.Dto.UserSocialLoginDTO;

import java.util.List;

public interface UserSocialLoginService {
    List<UserSocialLoginDTO> getList();
    UserSocialLoginDTO getUserSocialLoginById(Integer id);
    UserSocialLoginDTO createEndUpdateUserSocialLogin(UserSocialLoginDTO userSocialLoginDTO);
    void deleteUserSocialLogin(Integer id);
}

package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.RefreshTokenDTO;
import com.example.WebsiteBanHang2.Dto.UserAccountDTO;

import java.util.List;

public interface UserAccountService {
    List<UserAccountDTO> getList();
    UserAccountDTO getUserAccountById(Integer id);
    UserAccountDTO createEndUpdateUserAccount(UserAccountDTO accountDTO);
    void deleteUserAccount(Integer id);
}

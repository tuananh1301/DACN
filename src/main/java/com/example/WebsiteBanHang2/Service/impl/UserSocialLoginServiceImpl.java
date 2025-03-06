package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.UserSocialLoginDTO;
import com.example.WebsiteBanHang2.Model.UserSocialLogin;
import com.example.WebsiteBanHang2.Repository.UserAccountRepository;
import com.example.WebsiteBanHang2.Repository.UserSocialLoginRepository;
import com.example.WebsiteBanHang2.Service.UserSocialLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSocialLoginServiceImpl implements UserSocialLoginService {
    @Autowired
    UserSocialLoginRepository userSocialLoginRepository;
    private UserSocialLoginDTO convertToDTO(UserSocialLogin userSocialLogin) {
        UserSocialLoginDTO userSocialLoginDTO = new UserSocialLoginDTO();
        userSocialLoginDTO.setId(userSocialLogin.getId());
        userSocialLoginDTO.setSocialId(userSocialLogin.getSocialId());
        userSocialLoginDTO.setUserId(userSocialLogin.getUserId());
        userSocialLoginDTO.setEmail(userSocialLogin.getEmail());
        userSocialLoginDTO.setProvider(userSocialLogin.getProvider());
        userSocialLoginDTO.setCreatedAt(userSocialLogin.getCreatedAt());
        return userSocialLoginDTO;
    }
    private UserSocialLogin convertToEntity(UserSocialLoginDTO userSocialLoginDTO) {
        UserSocialLogin userSocialLogin = new UserSocialLogin();
        userSocialLogin.setId(userSocialLoginDTO.getId());
        userSocialLogin.setSocialId(userSocialLoginDTO.getSocialId());
        userSocialLogin.setUserId(userSocialLoginDTO.getUserId());
        userSocialLogin.setEmail(userSocialLoginDTO.getEmail());
        userSocialLogin.setProvider(userSocialLoginDTO.getProvider());
        userSocialLogin.setCreatedAt(userSocialLoginDTO.getCreatedAt());
        return userSocialLogin;
    }

    @Override
    public List<UserSocialLoginDTO> getList() {
        List<UserSocialLogin> userSocialLogins = userSocialLoginRepository.findAll();
        return userSocialLogins.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserSocialLoginDTO getUserSocialLoginById(Integer id) {
        UserSocialLogin userSocialLogin = userSocialLoginRepository.findById(id).orElseThrow(() -> new RuntimeException("User Social không tồn tại id này: " + id));
        return convertToDTO(userSocialLogin);
    }

    @Override
    public UserSocialLoginDTO createEndUpdateUserSocialLogin(UserSocialLoginDTO userSocialLoginDTO) {
        UserSocialLogin userSocialLogin = convertToEntity(userSocialLoginDTO);
        UserSocialLogin savedUserSocialLogin = userSocialLoginRepository.save(userSocialLogin);
        return convertToDTO(savedUserSocialLogin);
    }

    @Override
    public void deleteUserSocialLogin(Integer id) {
        UserSocialLogin userSocialLogin = userSocialLoginRepository.findById(id).orElseThrow(() -> new RuntimeException("User Social không tồn tại id này: " + id));
        userSocialLoginRepository.delete(userSocialLogin);
    }
}

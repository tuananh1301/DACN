package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.UserAccountDTO;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Repository.UserAccountRepository;
import com.example.WebsiteBanHang2.Service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;
    private UserAccountDTO converToUserAccountDTO(UserAccount userAccount) {
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setId(userAccount.getId());
        userAccountDTO.setEmail(userAccount.getEmail());
        userAccountDTO.setPassword(userAccount.getPassword());
        userAccountDTO.setRole(userAccount.getRole());
        userAccountDTO.setStatus(userAccount.getStatus());
        userAccountDTO.setCreatedAt(userAccount.getCreatedAt());
        userAccountDTO.setLastLogin(userAccount.getLastLogin());
        return userAccountDTO;
    }
    private UserAccount converToUserAccount(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(userAccountDTO.getId());
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setPassword(userAccountDTO.getPassword());
        userAccount.setRole(userAccountDTO.getRole());
        userAccount.setStatus(userAccountDTO.getStatus());
        userAccount.setCreatedAt(userAccountDTO.getCreatedAt());
        userAccount.setLastLogin(userAccountDTO.getLastLogin());
        return userAccount;
    }

    @Override
    public List<UserAccountDTO> getList() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();
        return userAccounts.stream().map(this::converToUserAccountDTO).collect(Collectors.toList());
    }

    @Override
    public UserAccountDTO getUserAccountById(Integer id) {
        UserAccount userAccount = userAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("User Account không có id này: " + id));
        return converToUserAccountDTO(userAccount);
    }

    @Override
    public UserAccountDTO createEndUpdateUserAccount(UserAccountDTO accountDTO) {
        UserAccount userAccount = converToUserAccount(accountDTO);
        UserAccount userAccount1 = userAccountRepository.save(userAccount);
        return converToUserAccountDTO(userAccount1);
    }

    @Override
    public void deleteUserAccount(Integer id) {
        UserAccount userAccount = userAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("UserAccount không có id này: " + id));
        userAccountRepository.delete(userAccount);
    }
}

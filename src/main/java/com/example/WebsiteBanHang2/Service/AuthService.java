package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Model.LoginForm;
import com.example.WebsiteBanHang2.Model.RegisterRequest;
import com.example.WebsiteBanHang2.Model.UserAccount;

public interface AuthService {
    void register(RegisterRequest form);
    void registerStaff(RegisterRequest form);
    UserAccount login(LoginForm form);
}

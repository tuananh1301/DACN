package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Exception.AppException;
import com.example.WebsiteBanHang2.Exception.ErrorCode;
import com.example.WebsiteBanHang2.Model.LoginForm;
import com.example.WebsiteBanHang2.Model.RegisterRequest;
import com.example.WebsiteBanHang2.Model.CustomerInfo;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Repository.CustomerInfoRepository;
import com.example.WebsiteBanHang2.Repository.UserAccountRepository;
import com.example.WebsiteBanHang2.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void register(RegisterRequest form) {
        if (userAccountRepository.findByEmail(form.getEmail()) != null) {
            throw new AppException(ErrorCode.EMAIL_IN_USE);
        }
        UserAccount user = new UserAccount();
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setRole(UserAccount.Role.CUSTOMER);
        user.setStatus((byte) 1);
        UserAccount savedUser = userAccountRepository.save(user);

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setUserId(savedUser);
        customerInfo.setPhone(form.getPhone());
        customerInfo.setAddress(form.getAddress());
        customerInfoRepository.save(customerInfo);
    }

    @Override
    public UserAccount login(LoginForm form) {
//        System.out.println("Email nhập: " + form.getEmail());
//        System.out.println("Mật khẩu nhập: " + form.getPassword());
//
//        UserAccount user = userAccountRepository.findByEmail(form.getEmail());
//        if (user == null) {
//            System.out.println("Không tìm thấy user với email: " + form.getEmail());
//            throw new RuntimeException("Email hoặc mật khẩu không đúng!");
//        }
//
//        System.out.println("Mật khẩu trong DB: " + user.getPassword());
//        boolean matches = passwordEncoder.matches(form.getPassword(), user.getPassword());
//        System.out.println("Kết quả so khớp mật khẩu: " + matches);
//
//        if (!matches) {
//            throw new RuntimeException("Email hoặc mật khẩu không đúng!");
//        }
//
//        user.setLastLogin(LocalDate.now());
//        userAccountRepository.save(user);
//        return user;
            throw new UnsupportedOperationException("Use Spring Security for login");
    }
}

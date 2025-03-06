package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.UserSocialLoginDTO;
import com.example.WebsiteBanHang2.Model.UserSocialLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSocialLoginRepository extends JpaRepository<UserSocialLogin, Integer> {
}

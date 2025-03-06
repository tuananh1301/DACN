package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.StaffInfoDTO;
import com.example.WebsiteBanHang2.Model.StaffInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffInfoRepository extends JpaRepository<StaffInfo, Integer> {
}

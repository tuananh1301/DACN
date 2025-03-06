package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.HoaDonChiTietDTO;
import com.example.WebsiteBanHang2.Model.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    List<HoaDonChiTiet> findByHoaDonId_Id(Integer hoaDonId);

}

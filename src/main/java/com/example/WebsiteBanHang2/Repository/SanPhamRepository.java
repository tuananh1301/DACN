package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.SanPhamDTO;
import com.example.WebsiteBanHang2.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
}

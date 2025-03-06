package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.DanhMucDTO;
import com.example.WebsiteBanHang2.Model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}

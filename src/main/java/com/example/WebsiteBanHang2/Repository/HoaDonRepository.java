package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.HoaDonDTO;
import com.example.WebsiteBanHang2.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen trangThaiVanChuyen);
    List<HoaDon> findByTrangThaiVanChuyenAndNgayTaoBefore(HoaDon.TrangThaiVanChuyen trangThaiVanChuyen, LocalDate ngayTaoBefore);
}

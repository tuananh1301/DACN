package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {
    @Query("""
        select new com.example.WebsiteBanHang2.Dto.KichThuocDTO(
            kt.id,
            kt.maKichThuoc,
            kt.tenKichThuoc,
            kt.trangThai
        ) from SanPhamChiTiet spct 
        join KichThuoc kt 
        on spct.kichThuocId.id = kt.id
        where spct.kichThuocId=?1
        
""")
    public List<SanPhamChiTietDTO> getKichThuoc(Integer id);
}

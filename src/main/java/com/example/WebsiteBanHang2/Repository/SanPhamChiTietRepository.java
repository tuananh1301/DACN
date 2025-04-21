package com.example.WebsiteBanHang2.Repository;

import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {
    @Query(value = "SELECT san_pham_id,\n" +
            "    MAX(don_gia) AS don_gia,\n" +
            "    MAX(id) AS id,\n" +
            "    MAX(ngay_cap_nhat) AS ngay_cap_nhat,\n" +
            "    MAX(ngay_tao) AS ngay_tao,\n" +
            "    MAX(nguoi_cap_nhat) AS nguoi_cap_nhat,\n" +
            "    MAX(photo) AS photo,\n" +
            "    MAX(so_luong) AS so_luong,\n" +
            "    MAX(trang_thai) AS trang_thai,\n" +
            "    MAX(chat_lieu_id) AS chat_lieu_id,\n" +
            "    MAX(co_ao_id) AS co_ao_id,\n" +
            "    MAX(kich_thuoc_id) AS kich_thuoc_id,\n" +
            "    MAX(kieu_dang_id) AS kieu_dang_id,\n" +
            "    MAX(mau_sac_id) AS mau_sac_id,\n" +
            "    MAX(thiet_ke_id) AS thiet_ke_id,\n" +
            "    MAX(thuong_hieu_id) AS thuong_hieu_id FROM san_pham_chi_tiet GROUP BY san_pham_id", nativeQuery = true)
    List<SanPhamChiTiet> getGroupBySanPham();

    @Query("SELECT DISTINCT s.kichThuocId.tenKichThuoc FROM SanPhamChiTiet s WHERE s.sanPhamId.id = :sanPhamId")
    List<String> findDistinctKichThuocIdsBySanPhamId(@Param("sanPhamId") Integer sanPhamId);

    @Query("SELECT DISTINCT s.mauSacId.tenMauSac FROM SanPhamChiTiet s WHERE s.sanPhamId.id = :sanPhamId")
    List<String> findDistinctMauSacIdsBySanPhamId(@Param("sanPhamId") Integer sanPhamId);

    @Query("SELECT s.soLuong FROM SanPhamChiTiet s WHERE s.id = :id")
    Integer findSoLuongIdsBySanPhamId(@Param("id") Integer id);
}

package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.HoaDonDTO;
import com.example.WebsiteBanHang2.Model.DonViVanChuyen;
import com.example.WebsiteBanHang2.Model.HoaDon; // Thêm import này, giả định có model HoaDon
import com.example.WebsiteBanHang2.Model.StaffInfo;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Repository.HoaDonRepository;
import com.example.WebsiteBanHang2.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    private HoaDonDTO convertToDto(HoaDon hoaDon) {
        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        hoaDonDTO.setId(hoaDon.getId());
        hoaDonDTO.setIdKhachHang(hoaDon.getIdKhachHang());
        hoaDonDTO.setMaHoaDon(hoaDon.getMaHoaDon());
        hoaDonDTO.setLoaiDon(hoaDon.getLoaiDon());
        hoaDonDTO.setTongTien(hoaDon.getTongTien());
        hoaDonDTO.setIdDonViVanChuyen(hoaDon.getIdDonViVanChuyen());
        hoaDonDTO.setTrangThaiVanChuyen(hoaDon.getTrangThaiVanChuyen());
        hoaDonDTO.setNgayTao(hoaDon.getNgayTao());
        hoaDonDTO.setTongTien(hoaDon.getTongTien());
        hoaDonDTO.setTrangThai(hoaDon.getTrangThai());
        hoaDonDTO.setDiaChiGiaoHang(hoaDon.getDiaChiGiaoHang());
        return hoaDonDTO;
    }

    private HoaDon convertToEntity(HoaDonDTO hoaDonDTO) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(hoaDonDTO.getId());
        hoaDon.setIdKhachHang(hoaDon.getIdKhachHang());
        hoaDon.setMaHoaDon(hoaDonDTO.getMaHoaDon());
        hoaDon.setLoaiDon(hoaDonDTO.getLoaiDon());
        hoaDon.setTongTien(hoaDonDTO.getTongTien());
        hoaDon.setIdDonViVanChuyen(hoaDonDTO.getIdDonViVanChuyen());
        hoaDon.setTrangThaiVanChuyen(hoaDonDTO.getTrangThaiVanChuyen());
        hoaDon.setNgayTao(hoaDonDTO.getNgayTao());
        hoaDon.setTrangThai(hoaDonDTO.getTrangThai());
        hoaDon.setDiaChiGiaoHang(hoaDonDTO.getDiaChiGiaoHang());
        return hoaDon;
    }

    @Override
    public List<HoaDonDTO> getList() {
        List<HoaDon> hoaDonList = hoaDonRepository.findAll();
        return hoaDonList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public HoaDonDTO getHoaDonById(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại với ID: " + id));
        return convertToDto(hoaDon);
    }

    @Override
    public HoaDonDTO createEndUpdateHoaDon(HoaDonDTO hoaDonDTO) {
        HoaDon hoaDon = convertToEntity(hoaDonDTO);
        HoaDon hoaDonSaved = hoaDonRepository.save(hoaDon);
        return convertToDto(hoaDonSaved);
    }

    @Override
    public void deleteHoaDon(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại với ID: " + id));
        hoaDonRepository.delete(hoaDon);
    }
    @Override
    public List<HoaDon> findByTrangThaiVanChuyen(HoaDon.TrangThaiVanChuyen trangThai){
        return hoaDonRepository.findByTrangThaiVanChuyen(trangThai);
    }
}
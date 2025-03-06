package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.HoaDonChiTietDTO; // Thêm import này, giả định có DTO
import com.example.WebsiteBanHang2.Dto.HoaDonDTO;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.HoaDonChiTiet;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import com.example.WebsiteBanHang2.Repository.HoaDonChiTietRepository;
import com.example.WebsiteBanHang2.Service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    private HoaDonChiTietDTO convertToDto(HoaDonChiTiet hoaDonChiTiet) {
        HoaDonChiTietDTO hoaDonChiTietDTO = new HoaDonChiTietDTO();
        hoaDonChiTietDTO.setId(hoaDonChiTiet.getId());
        hoaDonChiTietDTO.setHoaDon(hoaDonChiTiet.getHoaDonId());
        hoaDonChiTietDTO.setSanPhamChiTietId(hoaDonChiTiet.getSanPhamChiTietId());
        hoaDonChiTietDTO.setSoLuong(hoaDonChiTiet.getSoLuong());
        hoaDonChiTietDTO.setDonGia(hoaDonChiTiet.getDonGia());
        hoaDonChiTietDTO.setThanhTien(hoaDonChiTiet.getThanhTien());
        hoaDonChiTietDTO.setTrangThai(hoaDonChiTiet.getTrangThai());
        return hoaDonChiTietDTO;
    }

    private HoaDonChiTiet convertToEntity(HoaDonChiTietDTO hoaDonChiTietDTO) {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setId(hoaDonChiTietDTO.getId());
        hoaDonChiTiet.setHoaDonId(hoaDonChiTietDTO.getHoaDon());
        hoaDonChiTiet.setSanPhamChiTietId(hoaDonChiTietDTO.getSanPhamChiTietId());
        hoaDonChiTiet.setSoLuong(hoaDonChiTietDTO.getSoLuong());
        hoaDonChiTiet.setDonGia(hoaDonChiTietDTO.getDonGia());
        hoaDonChiTiet.setThanhTien(hoaDonChiTietDTO.getThanhTien());
        hoaDonChiTiet.setTrangThai(hoaDonChiTietDTO.getTrangThai());
        return hoaDonChiTiet;
    }

    @Override
    public List<HoaDonChiTietDTO> getList() {
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.findAll();
        return hoaDonChiTietList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public HoaDonChiTietDTO getHoaDonChiTietById(Integer id) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn chi tiết không tồn tại với ID: " + id));
        return convertToDto(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTietDTO createEndUpdateHoaDonChiTiet(HoaDonChiTietDTO hoaDonChiTietDTO) {
        HoaDonChiTiet hoaDonChiTiet = convertToEntity(hoaDonChiTietDTO);
        HoaDonChiTiet hoaDonChiTietSaved = hoaDonChiTietRepository.save(hoaDonChiTiet);
        return convertToDto(hoaDonChiTietSaved);
    }

    @Override
    public void deleteHoaDonChiTiet(Integer id) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn chi tiết không tồn tại với ID: " + id));
        hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }
    @Override
    public List<HoaDonChiTiet> findByHoaDonId(Integer hoaDonId){
        return hoaDonChiTietRepository.findByHoaDonId_Id(hoaDonId);
    }
}
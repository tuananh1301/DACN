package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.*;
import com.example.WebsiteBanHang2.Repository.SanPhamChiTietRepository;
import com.example.WebsiteBanHang2.Service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    // Trong file SanPhamChiTietServiceImpl.java
    private SanPhamChiTietDTO convertToDto(SanPhamChiTiet sanPhamChiTiet) {
        SanPhamChiTietDTO sanPhamChiTietDTO = new SanPhamChiTietDTO();
        sanPhamChiTietDTO.setId(sanPhamChiTiet.getId());
        sanPhamChiTietDTO.setSanPhamId(sanPhamChiTiet.getSanPhamId());
        sanPhamChiTietDTO.setKichThuocId(sanPhamChiTiet.getKichThuocId());
        sanPhamChiTietDTO.setMauSacId(sanPhamChiTiet.getMauSacId());
        sanPhamChiTietDTO.setChatLieuId(sanPhamChiTiet.getChatLieuId());
        sanPhamChiTietDTO.setKieuDangId(sanPhamChiTiet.getKieuDangId());
        sanPhamChiTietDTO.setCoAoId(sanPhamChiTiet.getCoAoId());
        sanPhamChiTietDTO.setThietKeId(sanPhamChiTiet.getThietKeId());
        sanPhamChiTietDTO.setThuongHieuId(sanPhamChiTiet.getThuongHieuId());
        sanPhamChiTietDTO.setSoLuong(sanPhamChiTiet.getSoLuong());
        sanPhamChiTietDTO.setDonGia(sanPhamChiTiet.getDonGia());
        sanPhamChiTietDTO.setNgayTao(sanPhamChiTiet.getNgayTao());
        sanPhamChiTietDTO.setNgayCapNhat(sanPhamChiTiet.getNgayCapNhat());
        sanPhamChiTietDTO.setNguoiCapNhat(sanPhamChiTiet.getNguoiCapNhat());
        sanPhamChiTietDTO.setTrangThai(sanPhamChiTiet.getTrangThai());
        return sanPhamChiTietDTO;
    }

    private SanPhamChiTiet convertToEntity(SanPhamChiTietDTO sanPhamChiTietDTO) {
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        sanPhamChiTiet.setId(sanPhamChiTietDTO.getId());
        sanPhamChiTiet.setSanPhamId(sanPhamChiTietDTO.getSanPhamId());
        sanPhamChiTiet.setKichThuocId(sanPhamChiTietDTO.getKichThuocId());
        sanPhamChiTiet.setMauSacId(sanPhamChiTietDTO.getMauSacId());
        sanPhamChiTiet.setChatLieuId(sanPhamChiTietDTO.getChatLieuId());
        sanPhamChiTiet.setKieuDangId(sanPhamChiTietDTO.getKieuDangId());
        sanPhamChiTiet.setCoAoId(sanPhamChiTietDTO.getCoAoId());
        sanPhamChiTiet.setThietKeId(sanPhamChiTietDTO.getThietKeId());
        sanPhamChiTiet.setThuongHieuId(sanPhamChiTietDTO.getThuongHieuId());
        sanPhamChiTiet.setSoLuong(sanPhamChiTietDTO.getSoLuong());
        sanPhamChiTiet.setDonGia(sanPhamChiTietDTO.getDonGia());
        sanPhamChiTiet.setNgayTao(sanPhamChiTietDTO.getNgayTao());
        sanPhamChiTiet.setNgayCapNhat(sanPhamChiTietDTO.getNgayCapNhat());
        sanPhamChiTiet.setNguoiCapNhat(sanPhamChiTietDTO.getNguoiCapNhat());
        sanPhamChiTiet.setTrangThai(sanPhamChiTietDTO.getTrangThai());
        return sanPhamChiTiet;
    }

    @Override
    public List<SanPhamChiTietDTO> getListDTO() {
        List<SanPhamChiTiet> sanPhamChiTietList = sanPhamChiTietRepository.findAll();
        return sanPhamChiTietList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @Override
    public List<SanPhamChiTiet> getList() {
        return sanPhamChiTietRepository.findAll();
    }

    @Override
    public SanPhamChiTietDTO getSanPhamChiTietById(Integer id) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm chi tiết không tồn tại với ID: " + id));
        return convertToDto(sanPhamChiTiet);
    }

    @Override
    public SanPhamChiTietDTO createEndUpdateSanPhamChiTiet(SanPhamChiTietDTO sanPhamChiTietDTO) {
        SanPhamChiTiet sanPhamChiTiet = convertToEntity(sanPhamChiTietDTO);
        SanPhamChiTiet sanPhamChiTietSaved = sanPhamChiTietRepository.save(sanPhamChiTiet);
        return convertToDto(sanPhamChiTietSaved);
    }

    @Override
    public void deleteSanPhamChiTiet(Integer id) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm chi tiết không tồn tại với ID: " + id));
        sanPhamChiTietRepository.delete(sanPhamChiTiet);
    }
}
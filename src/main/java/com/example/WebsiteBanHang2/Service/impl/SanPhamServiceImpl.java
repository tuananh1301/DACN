package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.SanPhamDTO;
import com.example.WebsiteBanHang2.Model.SanPham;
import com.example.WebsiteBanHang2.Repository.SanPhamRepository;
import com.example.WebsiteBanHang2.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;
    private SanPhamDTO convertSanPhamDTO(SanPham sanPham) {
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setId(sanPham.getId());
        sanPhamDTO.setMaSanPham(sanPham.getMaSanPham());
        sanPhamDTO.setTenSanPham(sanPham.getTenSanPham());
        sanPhamDTO.setTrangThai(sanPham.getTrangThai());
        sanPhamDTO.setMoTa(sanPham.getMoTa());
        sanPhamDTO.setIdDanhMuc(sanPham.getIdDanhMuc());
        return sanPhamDTO;
    };
    private SanPham convertSanPham(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = new SanPham();
        sanPham.setId(sanPhamDTO.getId());
        sanPham.setMaSanPham(sanPhamDTO.getMaSanPham());
        sanPham.setTenSanPham(sanPhamDTO.getTenSanPham());
        sanPham.setMoTa(sanPhamDTO.getMoTa());
        sanPham.setIdDanhMuc(sanPhamDTO.getIdDanhMuc());
        sanPham.setTrangThai(sanPhamDTO.getTrangThai());
        return sanPham;
    }

    @Override
    public List<SanPhamDTO> getList() {
        List<SanPham> sanPhamList = sanPhamRepository.findAll();
        return sanPhamList.stream().map(this::convertSanPhamDTO).collect(Collectors.toList());
    }

    @Override
    public SanPhamDTO getSanPhamDTOById(Integer id) {
        SanPham sanPham = sanPhamRepository.findById(id).orElseThrow(() -> new RuntimeException("SanPham Not Found ID"));
        return convertSanPhamDTO(sanPham);
    }

    @Override
    public SanPhamDTO createEndUpdateSanPhamDTO(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = convertSanPham(sanPhamDTO);
        SanPham sanPham1 = sanPhamRepository.save(sanPham);
        return convertSanPhamDTO(sanPham1);
    }

    @Override
    public void deleteSanPhamDTO(Integer id) {
        SanPham sanPham = sanPhamRepository.findById(id).orElseThrow(() -> new RuntimeException("SanPham Not Found ID"));
        sanPhamRepository.delete(sanPham);
    }
}

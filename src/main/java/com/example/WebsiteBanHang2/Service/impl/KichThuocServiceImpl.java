package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.KichThuocDTO;
import com.example.WebsiteBanHang2.Model.KichThuoc; // Thêm import này, giả định có model KichThuoc
import com.example.WebsiteBanHang2.Repository.KichThuocRepository;
import com.example.WebsiteBanHang2.Service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KichThuocServiceImpl implements KichThuocService {
    @Autowired
    private KichThuocRepository kichThuocRepository;

    private KichThuocDTO convertToDto(KichThuoc kichThuoc) {
        KichThuocDTO kichThuocDTO = new KichThuocDTO();
        kichThuocDTO.setId(kichThuoc.getId());
        kichThuocDTO.setMaKichThuoc(kichThuoc.getMaKichThuoc());
        kichThuocDTO.setTenKichThuoc(kichThuoc.getTenKichThuoc());
        kichThuocDTO.setTrangThai(kichThuoc.getTrangThai());
        return kichThuocDTO;
    }

    private KichThuoc convertToEntity(KichThuocDTO kichThuocDTO) {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setId(kichThuocDTO.getId());
        kichThuoc.setMaKichThuoc(kichThuocDTO.getMaKichThuoc());
        kichThuoc.setTenKichThuoc(kichThuocDTO.getTenKichThuoc());
        kichThuoc.setTrangThai(kichThuocDTO.getTrangThai());
        return kichThuoc;
    }

    @Override
    public List<KichThuocDTO> getList() {
        List<KichThuoc> kichThuocList = kichThuocRepository.findAll();
        return kichThuocList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public KichThuocDTO getKichThuocById(Integer id) {
        KichThuoc kichThuoc = kichThuocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kích thước không tồn tại với ID: " + id));
        return convertToDto(kichThuoc);
    }

    @Override
    public KichThuocDTO createEndUpdateKichThuoc(KichThuocDTO kichThuocDTO) {
        KichThuoc kichThuoc = convertToEntity(kichThuocDTO);
        KichThuoc kichThuocSaved = kichThuocRepository.save(kichThuoc);
        return convertToDto(kichThuocSaved);
    }

    @Override
    public void deleteKichThuoc(Integer id) {
        KichThuoc kichThuoc = kichThuocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kích thước không tồn tại với ID: " + id));
        kichThuocRepository.delete(kichThuoc);
    }
}
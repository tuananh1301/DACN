package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.KieuDangDTO;
import com.example.WebsiteBanHang2.Model.KieuDang; // Thêm import này, giả định có model KieuDang
import com.example.WebsiteBanHang2.Repository.KieuDangRepository;
import com.example.WebsiteBanHang2.Service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KieuDangServiceImpl implements KieuDangService {
    @Autowired
    private KieuDangRepository kieuDangRepository;

    private KieuDangDTO convertToDto(KieuDang kieuDang) {
        KieuDangDTO kieuDangDTO = new KieuDangDTO();
        kieuDangDTO.setId(kieuDang.getId());
        kieuDangDTO.setMaKieuDang(kieuDang.getMaKieuDang());
        kieuDangDTO.setTenKieuDang(kieuDang.getTenKieuDang());
        kieuDangDTO.setTrangThai(kieuDang.getTrangThai());
        return kieuDangDTO;
    }

    private KieuDang convertToEntity(KieuDangDTO kieuDangDTO) {
        KieuDang kieuDang = new KieuDang();
        kieuDang.setId(kieuDangDTO.getId());
        kieuDang.setMaKieuDang(kieuDangDTO.getMaKieuDang());
        kieuDang.setTenKieuDang(kieuDangDTO.getTenKieuDang());
        kieuDang.setTrangThai(kieuDangDTO.getTrangThai());
        return kieuDang;
    }

    @Override
    public List<KieuDangDTO> getListDTO() {
        List<KieuDang> kieuDangList = kieuDangRepository.findAll();
        return kieuDangList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @Override
    public List<KieuDang> getList() {
        return kieuDangRepository.findAll();
    }

    @Override
    public KieuDangDTO getKieuDangById(Integer id) {
        KieuDang kieuDang = kieuDangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kiểu dáng không tồn tại với ID: " + id));
        return convertToDto(kieuDang);
    }

    @Override
    public KieuDangDTO createEndUpdateKieuDang(KieuDangDTO kieuDangDTO) {
        KieuDang kieuDang = convertToEntity(kieuDangDTO);
        KieuDang kieuDangSaved = kieuDangRepository.save(kieuDang);
        return convertToDto(kieuDangSaved);
    }

    @Override
    public void deleteKieuDang(Integer id) {
        KieuDang kieuDang = kieuDangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kiểu dáng không tồn tại với ID: " + id));
        kieuDangRepository.delete(kieuDang);
    }
}
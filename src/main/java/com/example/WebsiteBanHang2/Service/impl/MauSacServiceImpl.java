package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.MauSacDTO;
import com.example.WebsiteBanHang2.Model.MauSac; // Thêm import này, giả định có model MauSac
import com.example.WebsiteBanHang2.Repository.MauSacRepository;
import com.example.WebsiteBanHang2.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    private MauSacDTO convertToDto(MauSac mauSac) {
        MauSacDTO mauSacDTO = new MauSacDTO();
        mauSacDTO.setId(mauSac.getId());
        mauSacDTO.setMaMauSac(mauSac.getMaMauSac());
        mauSacDTO.setTenMauSac(mauSac.getTenMauSac());
        mauSacDTO.setTrangThai(mauSac.getTrangThai());
        return mauSacDTO;
    }

    private MauSac convertToEntity(MauSacDTO mauSacDTO) {
        MauSac mauSac = new MauSac();
        mauSac.setId(mauSacDTO.getId());
        mauSac.setMaMauSac(mauSacDTO.getMaMauSac());
        mauSac.setTenMauSac(mauSacDTO.getTenMauSac());
        mauSac.setTrangThai(mauSacDTO.getTrangThai());
        return mauSac;
    }

    @Override
    public List<MauSacDTO> getList() {
        List<MauSac> mauSacList = mauSacRepository.findAll();
        return mauSacList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public MauSacDTO getMauSacById(Integer id) {
        MauSac mauSac = mauSacRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Màu sắc không tồn tại với ID: " + id));
        return convertToDto(mauSac);
    }

    @Override
    public MauSacDTO createEndUpdateMauSac(MauSacDTO mauSacDTO) {
        MauSac mauSac = convertToEntity(mauSacDTO);
        MauSac mauSacSaved = mauSacRepository.save(mauSac);
        return convertToDto(mauSacSaved);
    }

    @Override
    public void deleteMauSac(Integer id) {
        MauSac mauSac = mauSacRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Màu sắc không tồn tại với ID: " + id));
        mauSacRepository.delete(mauSac);
    }
}
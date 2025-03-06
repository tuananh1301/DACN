package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.DanhMucDTO;
import com.example.WebsiteBanHang2.Model.DanhMuc;
import com.example.WebsiteBanHang2.Repository.DanhMucRepository;
import com.example.WebsiteBanHang2.Service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;

    private DanhMucDTO convertToDto(DanhMuc danhMuc) {
        DanhMucDTO danhMucDTO = new DanhMucDTO();
        danhMucDTO.setId(danhMuc.getId());
        danhMucDTO.setMaDanhMuc(danhMuc.getMaDanhMuc());
        danhMucDTO.setTenDanhMuc(danhMuc.getTenDanhMuc());
        danhMucDTO.setTrangThai(danhMuc.getTrangThai());
        return danhMucDTO;
    }

    private DanhMuc convertToEntity(DanhMucDTO danhMucDTO) {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId(danhMucDTO.getId());
        danhMuc.setMaDanhMuc(danhMucDTO.getMaDanhMuc());
        danhMuc.setTenDanhMuc(danhMucDTO.getTenDanhMuc());
        danhMuc.setTrangThai(danhMucDTO.getTrangThai());
        return danhMuc;
    }

    @Override
    public List<DanhMucDTO> getList() {
        List<DanhMuc> danhMucList = danhMucRepository.findAll();
        return danhMucList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DanhMucDTO getDanhMucById(Integer id) {
        DanhMuc danhMuc = danhMucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại với ID: " + id));
        return convertToDto(danhMuc);
    }

    @Override
    public DanhMucDTO createEndUpdateDanhMuc(DanhMucDTO danhMucDTO) {
        DanhMuc danhMuc = convertToEntity(danhMucDTO);
        DanhMuc danhMucSaved = danhMucRepository.save(danhMuc);
        return convertToDto(danhMucSaved);
    }

    @Override
    public void deleteDanhMuc(Integer id) {
        DanhMuc danhMuc = danhMucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại với ID: " + id));
        danhMucRepository.delete(danhMuc);
    }
}
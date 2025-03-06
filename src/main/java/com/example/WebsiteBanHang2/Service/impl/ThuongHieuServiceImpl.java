package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.ThuongHieuDTO;
import com.example.WebsiteBanHang2.Model.ThuongHieu;
import com.example.WebsiteBanHang2.Repository.ThuongHieuRepository;
import com.example.WebsiteBanHang2.Service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    ThuongHieuRepository thuongHieuRepository;
    private ThuongHieuDTO convertToDto(ThuongHieu thuongHieu) {
        ThuongHieuDTO dto = new ThuongHieuDTO();
        dto.setId(thuongHieu.getId());
        dto.setTrangThai(thuongHieu.getTrangThai());
        dto.setMaThuongHieu(thuongHieu.getMaThuongHieu());
        dto.setTenThuongHieu(thuongHieu.getTenThuongHieu());
        return dto;
    }
    private ThuongHieu convertToEntity(ThuongHieuDTO dto) {
        ThuongHieu dtoEntity = new ThuongHieu();
        dtoEntity.setId(dto.getId());
        dtoEntity.setTrangThai(dto.getTrangThai());
        dtoEntity.setMaThuongHieu(dto.getMaThuongHieu());
        dtoEntity.setTenThuongHieu(dto.getTenThuongHieu());
        return dtoEntity;
    }
    @Override
    public List<ThuongHieuDTO> getList() {
        List<ThuongHieu> list = thuongHieuRepository.findAll();
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ThuongHieuDTO getThuongHieuById(Integer id) {
        ThuongHieu thuongHieu= thuongHieuRepository.findById(id).orElseThrow(()->new RuntimeException("ThuongHieu không tồn tại id này: " + id));
        return convertToDto(thuongHieu);
    }

    @Override
    public ThuongHieuDTO createEndUpdateThuongHieu(ThuongHieuDTO thuongHieuDTO) {
        ThuongHieu thuongHieu = convertToEntity(thuongHieuDTO);
        ThuongHieu saved = thuongHieuRepository.save(thuongHieu);
        return convertToDto(saved);
    }

    @Override
    public void deleteThuongHieu(Integer id) {
        ThuongHieu thuongHieu = thuongHieuRepository.findById(id).orElseThrow(() -> new RuntimeException("Thương hiệu không tồn tại id này:" + id));
        thuongHieuRepository.delete(thuongHieu);
    }
}

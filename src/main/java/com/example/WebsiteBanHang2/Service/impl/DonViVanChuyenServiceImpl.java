package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.DonViVanChuyenDTO;
import com.example.WebsiteBanHang2.Model.DonViVanChuyen;
import com.example.WebsiteBanHang2.Repository.DonViVanChuyenRepository;
import com.example.WebsiteBanHang2.Service.DonViVanChuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonViVanChuyenServiceImpl implements DonViVanChuyenService {
    @Autowired
    private DonViVanChuyenRepository donViVanChuyenRepository;

    private DonViVanChuyenDTO convertToDto(DonViVanChuyen donViVanChuyen) {
        DonViVanChuyenDTO donViVanChuyenDTO = new DonViVanChuyenDTO();
        donViVanChuyenDTO.setId(donViVanChuyen.getId());
        donViVanChuyenDTO.setTenDonVi(donViVanChuyen.getTenDonVi());
        donViVanChuyenDTO.setMaDonVi(donViVanChuyen.getMaDonVi());
        donViVanChuyenDTO.setTrangThai(donViVanChuyen.getTrangThai());
        return donViVanChuyenDTO;
    }

    private DonViVanChuyen convertToEntity(DonViVanChuyenDTO donViVanChuyenDTO) {
        DonViVanChuyen donViVanChuyen = new DonViVanChuyen();
        donViVanChuyen.setId(donViVanChuyenDTO.getId());
        donViVanChuyen.setTenDonVi(donViVanChuyenDTO.getTenDonVi());
        donViVanChuyen.setMaDonVi(donViVanChuyenDTO.getMaDonVi());
        donViVanChuyen.setTrangThai(donViVanChuyenDTO.getTrangThai());
        return donViVanChuyen;
    }

    @Override
    public List<DonViVanChuyenDTO> getList() {
        List<DonViVanChuyen> donViVanChuyenList = donViVanChuyenRepository.findAll();
        return donViVanChuyenList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DonViVanChuyenDTO getDonViVanChuyenById(Integer id) {
        DonViVanChuyen donViVanChuyen = donViVanChuyenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn vị vận chuyển không tồn tại với ID: " + id));
        return convertToDto(donViVanChuyen);
    }

    @Override
    public DonViVanChuyenDTO createEndUpdateDonViVanChuyen(DonViVanChuyenDTO donViVanChuyenDTO) {
        DonViVanChuyen donViVanChuyen = convertToEntity(donViVanChuyenDTO);
        DonViVanChuyen donViVanChuyenSaved = donViVanChuyenRepository.save(donViVanChuyen);
        return convertToDto(donViVanChuyenSaved);
    }

    @Override
    public void deleteDonViVanChuyen(Integer id) {
        DonViVanChuyen donViVanChuyen = donViVanChuyenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn vị vận chuyển không tồn tại với ID: " + id));
        donViVanChuyenRepository.delete(donViVanChuyen);
    }
}
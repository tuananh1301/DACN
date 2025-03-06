package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.PhuongThucThanhToanDTO;
import com.example.WebsiteBanHang2.Model.PhuongThucThanhToan; // Thêm import này, giả định có model PhuongThucThanhToan
import com.example.WebsiteBanHang2.Repository.PhuongThucThanhToanRepository; // Sửa tên repository
import com.example.WebsiteBanHang2.Service.PhuongThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhuongThucThanhToanServiceImpl implements PhuongThucThanhToanService {
    @Autowired
    private PhuongThucThanhToanRepository phuongThucThanhToanRepository;

    private PhuongThucThanhToanDTO convertToDto(PhuongThucThanhToan phuongThucThanhToan) {
        PhuongThucThanhToanDTO phuongThucThanhToanDTO = new PhuongThucThanhToanDTO();
        phuongThucThanhToanDTO.setId(phuongThucThanhToan.getId());
        phuongThucThanhToanDTO.setMaPhuongThuc(phuongThucThanhToan.getMaPhuongThuc());
        phuongThucThanhToanDTO.setTenPhuongThuc(phuongThucThanhToan.getTenPhuongThuc());
        phuongThucThanhToanDTO.setGhiChu(phuongThucThanhToan.getGhiChu());
        phuongThucThanhToanDTO.setTrangThai(phuongThucThanhToan.getTrangThai());
        return phuongThucThanhToanDTO;
    }

    private PhuongThucThanhToan convertToEntity(PhuongThucThanhToanDTO phuongThucThanhToanDTO) {
        PhuongThucThanhToan phuongThucThanhToan = new PhuongThucThanhToan();
        phuongThucThanhToan.setId(phuongThucThanhToanDTO.getId());
        phuongThucThanhToan.setMaPhuongThuc(phuongThucThanhToanDTO.getMaPhuongThuc());
        phuongThucThanhToan.setTenPhuongThuc(phuongThucThanhToanDTO.getTenPhuongThuc());
        phuongThucThanhToan.setGhiChu(phuongThucThanhToanDTO.getGhiChu());
        phuongThucThanhToan.setTrangThai(phuongThucThanhToanDTO.getTrangThai());
        return phuongThucThanhToan;
    }

    @Override
    public List<PhuongThucThanhToanDTO> getList() {
        List<PhuongThucThanhToan> phuongThucThanhToanList = phuongThucThanhToanRepository.findAll();
        return phuongThucThanhToanList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PhuongThucThanhToanDTO getPhuongThucThanhToanById(Integer id) {
        PhuongThucThanhToan phuongThucThanhToan = phuongThucThanhToanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phương thức thanh toán không tồn tại với ID: " + id));
        return convertToDto(phuongThucThanhToan);
    }

    @Override
    public PhuongThucThanhToanDTO createEndUpdatePhuongThucThanhToan(PhuongThucThanhToanDTO phuongThucThanhToanDTO) {
        PhuongThucThanhToan phuongThucThanhToan = convertToEntity(phuongThucThanhToanDTO);
        PhuongThucThanhToan phuongThucThanhToanSaved = phuongThucThanhToanRepository.save(phuongThucThanhToan);
        return convertToDto(phuongThucThanhToanSaved);
    }

    @Override
    public void deletePhuongThucThanhToan(Integer id) {
        PhuongThucThanhToan phuongThucThanhToan = phuongThucThanhToanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phương thức thanh toán không tồn tại với ID: " + id));
        phuongThucThanhToanRepository.delete(phuongThucThanhToan);
    }
}
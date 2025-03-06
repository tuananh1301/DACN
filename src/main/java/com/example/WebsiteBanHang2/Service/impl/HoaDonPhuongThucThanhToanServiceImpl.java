package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.HoaDonPhuongThucThanhToanDTO;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.HoaDonPhuongThucThanhToan;
import com.example.WebsiteBanHang2.Model.PhuongThucThanhToan;
import com.example.WebsiteBanHang2.Repository.HoaDonPhuongThucThanhToanRepository;
import com.example.WebsiteBanHang2.Service.HoaDonPhuongThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonPhuongThucThanhToanServiceImpl implements HoaDonPhuongThucThanhToanService {
    @Autowired
    HoaDonPhuongThucThanhToanRepository hoaDonPhuongThucThanhToanRepository;

    private HoaDonPhuongThucThanhToanDTO convertToDto(HoaDonPhuongThucThanhToan hoaDonPhuongThucThanhToan) {
        HoaDonPhuongThucThanhToanDTO hoaDonPhuongThucThanhToanDTO = new HoaDonPhuongThucThanhToanDTO();
        hoaDonPhuongThucThanhToanDTO.setId(hoaDonPhuongThucThanhToan.getId());
        hoaDonPhuongThucThanhToanDTO.setHoaDonId(hoaDonPhuongThucThanhToan.getHoaDonId().getId());
        hoaDonPhuongThucThanhToanDTO.setPhuongThucThanhToanId(hoaDonPhuongThucThanhToan.getPhuongThucThanhToanId().getId());
        hoaDonPhuongThucThanhToanDTO.setSoTienThanhToan(hoaDonPhuongThucThanhToan.getSoTienThanhToan());
        hoaDonPhuongThucThanhToanDTO.setNgayThucHienThanhToan(hoaDonPhuongThucThanhToan.getNgayThucHienThanhToan());
        hoaDonPhuongThucThanhToanDTO.setGhiChu(hoaDonPhuongThucThanhToan.getGhiChu());
        return hoaDonPhuongThucThanhToanDTO;
    }

    private HoaDonPhuongThucThanhToan convertToEntity(HoaDonPhuongThucThanhToanDTO hoaDonPhuongThucThanhToanDTO) {
        HoaDonPhuongThucThanhToan hoaDonPhuongThucThanhToan = new HoaDonPhuongThucThanhToan();
        hoaDonPhuongThucThanhToan.setId(hoaDonPhuongThucThanhToanDTO.getId());
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(hoaDonPhuongThucThanhToanDTO.getId());
        hoaDonPhuongThucThanhToan.setHoaDonId(hoaDon);
        PhuongThucThanhToan phuongThucThanhToan = new PhuongThucThanhToan();
        phuongThucThanhToan.setId(hoaDonPhuongThucThanhToanDTO.getPhuongThucThanhToanId());
        hoaDonPhuongThucThanhToan.setPhuongThucThanhToanId(phuongThucThanhToan);
        hoaDonPhuongThucThanhToan.setSoTienThanhToan(hoaDonPhuongThucThanhToanDTO.getSoTienThanhToan());
        hoaDonPhuongThucThanhToan.setNgayThucHienThanhToan(hoaDonPhuongThucThanhToanDTO.getNgayThucHienThanhToan());
        hoaDonPhuongThucThanhToan.setGhiChu(hoaDonPhuongThucThanhToanDTO.getGhiChu());
        return hoaDonPhuongThucThanhToan;
    }

    @Override
    public List<HoaDonPhuongThucThanhToanDTO> getList() {
        List<HoaDonPhuongThucThanhToan> hoaDonPhuongThucThanhToanList = hoaDonPhuongThucThanhToanRepository.findAll();
        return hoaDonPhuongThucThanhToanList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public HoaDonPhuongThucThanhToanDTO getHoaDonPhuongThucThanhToanById(Integer id) {
        HoaDonPhuongThucThanhToan hoaDonPhuongThucThanhToan = hoaDonPhuongThucThanhToanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn phương thức thanh toán không tồn tại với ID: " + id));
        return convertToDto(hoaDonPhuongThucThanhToan);
    }

    @Override
    public HoaDonPhuongThucThanhToanDTO createEndUpdateHoaDonPhuongThucThanhToan(HoaDonPhuongThucThanhToanDTO hoaDonPhuongThucThanhToanDTO) {
        HoaDonPhuongThucThanhToan hoaDonPhuongThucThanhToan = convertToEntity(hoaDonPhuongThucThanhToanDTO);
        HoaDonPhuongThucThanhToan hoaDonPhuongThucThanhToanSaved = hoaDonPhuongThucThanhToanRepository.save(hoaDonPhuongThucThanhToan);
        return convertToDto(hoaDonPhuongThucThanhToanSaved);
    }

    @Override
    public void deleteHoaDonPhuongThucThanhToan(Integer id) {
        HoaDonPhuongThucThanhToan hoaDonPhuongThucThanhToan = hoaDonPhuongThucThanhToanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hóa đơn phương thức thanh toán không tồn tại với ID: " + id));
        hoaDonPhuongThucThanhToanRepository.delete(hoaDonPhuongThucThanhToan);
    }
}
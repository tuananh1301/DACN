package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.ThietKeDTO;
import com.example.WebsiteBanHang2.Model.ThietKe;
import com.example.WebsiteBanHang2.Repository.ThietKeRepository;
import com.example.WebsiteBanHang2.Service.ThietKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThietKeServiceImpl implements ThietKeService {
    @Autowired
    ThietKeRepository thietKeRepository;
    private ThietKeDTO convertToThietKeDTO(ThietKe thietKe){
        ThietKeDTO thietKeDTO = new ThietKeDTO();
        thietKeDTO.setId(thietKe.getId());
        thietKeDTO.setMaThietKe(thietKe.getMaThietKe());
        thietKeDTO.setTenThietKe(thietKe.getTenThietKe());
        thietKeDTO.setTrangThai(thietKe.getTrangThai());
        return thietKeDTO;
    }
    private ThietKe convertToThietKeEntity(ThietKeDTO thietKeDTO){
        ThietKe thietKe = new ThietKe();
        thietKe.setId(thietKeDTO.getId());
        thietKe.setMaThietKe(thietKeDTO.getMaThietKe());
        thietKe.setTenThietKe(thietKeDTO.getTenThietKe());
        thietKe.setTrangThai(thietKeDTO.getTrangThai());
        return thietKe;
    }
    @Override
    public List<ThietKeDTO> getList() {
        List<ThietKe> thietKeList = thietKeRepository.findAll();
        return thietKeList.stream().map(this::convertToThietKeDTO).collect(Collectors.toList());
    }

    @Override
    public ThietKeDTO getThietKeById(Integer id) {
        ThietKe thietKe = thietKeRepository.findById(id).orElseThrow(()->new RuntimeException("ThietKe Not Found id"));
        return convertToThietKeDTO(thietKe);
    }

    @Override
    public ThietKeDTO createEndUpdateThietKe(ThietKeDTO thietKeDTO) {
        ThietKe thietKe = convertToThietKeEntity(thietKeDTO);
        ThietKe savedThietke = thietKeRepository.save(thietKe);
        return convertToThietKeDTO(savedThietke);
    }

    @Override
    public void deleteThietKe(Integer id) {
        ThietKe thietKe = thietKeRepository.findById(id).orElseThrow(()->new RuntimeException("ThietKe Not Found id"));
        thietKeRepository.delete(thietKe);
    }
}

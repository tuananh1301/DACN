package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.StaffInfoDTO;
import com.example.WebsiteBanHang2.Model.StaffInfo;
import com.example.WebsiteBanHang2.Repository.StaffInfoRepository;
import com.example.WebsiteBanHang2.Service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {
    @Autowired
    StaffInfoRepository staffInfoRepository;
    private StaffInfoDTO convertToDTO(StaffInfo staffInfo) {
        StaffInfoDTO staffInfoDTO = new StaffInfoDTO();
        staffInfoDTO.setId(staffInfo.getId());
        staffInfoDTO.setStaffCode(staffInfo.getStaffCode());
        staffInfoDTO.setDepartment(staffInfo.getDepartment());
        staffInfoDTO.setUserId(staffInfo.getUserId());
        return staffInfoDTO;
    };
    private StaffInfo convertToEntity(StaffInfoDTO staffInfoDTO) {
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setStaffCode(staffInfoDTO.getStaffCode());
        staffInfo.setDepartment(staffInfoDTO.getDepartment());
        staffInfo.setUserId(staffInfoDTO.getUserId());
        staffInfo.setId(staffInfoDTO.getId());
        return staffInfo;
    }

    @Override
    public List<StaffInfoDTO> getList() {
        List<StaffInfo> list = staffInfoRepository.findAll();
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StaffInfoDTO getStaffInfoById(Integer id) {
        StaffInfo staffInfo = staffInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("staffInfo not found id"));
        return convertToDTO(staffInfo);
    }

    @Override
    public StaffInfoDTO createEndUpdateStaffInfo(StaffInfoDTO staffInfoDTO) {
        StaffInfo staffInfo = convertToEntity(staffInfoDTO);
        StaffInfo savedStaffInfo = staffInfoRepository.save(staffInfo);
        return convertToDTO(savedStaffInfo);
    }

    @Override
    public void deleteStaffInfo(Integer id) {
        StaffInfo staffInfo = staffInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("staffInfo not found id"));
        staffInfoRepository.delete(staffInfo);
    }
}

package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.CustomerInfoDTO;
import com.example.WebsiteBanHang2.Model.CustomerInfo;
import com.example.WebsiteBanHang2.Repository.CustomerInfoRepository;
import com.example.WebsiteBanHang2.Service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    private CustomerInfoDTO convertToDto(CustomerInfo customerInfo) {
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        customerInfoDTO.setId(customerInfo.getId());
        customerInfoDTO.setAddress(customerInfo.getAddress());
        customerInfoDTO.setPhone(customerInfo.getPhone());
        customerInfoDTO.setBirthDate(customerInfo.getBirthDate());
        customerInfoDTO.setUserId(customerInfo.getId());
        return customerInfoDTO;
    }

    private CustomerInfo convertToEntity(CustomerInfoDTO customerInfoDTO) {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(customerInfoDTO.getId());
        customerInfo.setAddress(customerInfoDTO.getAddress());
        customerInfo.setPhone(customerInfoDTO.getPhone());
        customerInfo.setBirthDate(customerInfoDTO.getBirthDate());
        customerInfo.setId(customerInfoDTO.getUserId());
        return customerInfo;
    }

    @Override
    public List<CustomerInfoDTO> getList() {
        List<CustomerInfo> customerInfoList = customerInfoRepository.findAll();
        return customerInfoList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CustomerInfoDTO getCustomerInfoById(Integer id) {
        CustomerInfo customerInfo = customerInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerInfo không tồn tại với ID: " + id));
        return convertToDto(customerInfo);
    }

    @Override
    public CustomerInfoDTO createEndUpdateCustomerInfo(CustomerInfoDTO customerInfoDTO) {
        CustomerInfo customerInfo = convertToEntity(customerInfoDTO);
        CustomerInfo customerInfoSaved = customerInfoRepository.save(customerInfo);
        return convertToDto(customerInfoSaved);
    }

    @Override
    public void deleteCustomerInfo(Integer id) {
        CustomerInfo customerInfo = customerInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerInfo không tồn tại với ID: " + id));
        customerInfoRepository.delete(customerInfo);
    }
}
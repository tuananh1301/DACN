package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.CoAoDTO;
import com.example.WebsiteBanHang2.Model.CoAo;
import com.example.WebsiteBanHang2.Repository.CoAoRepository;
import com.example.WebsiteBanHang2.Service.CoAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoAoServiceImpl implements CoAoService {
    @Autowired
    CoAoRepository coAoRepository;
    private CoAoDTO convertToDto(CoAo coAo) {
        CoAoDTO coAoDTO = new CoAoDTO();
        coAoDTO.setId(coAo.getId());
        coAoDTO.setMaCoAo(coAo.getMaCoAo());
        coAoDTO.setTenCoAo(coAo.getTenCoAo());
        coAoDTO.setTrangThai(coAo.getTrangThai());
        return coAoDTO;
    }
    private CoAo convertToEntity(CoAoDTO coAoDTO) {
        CoAo coAo = new CoAo();
        coAo.setId(coAoDTO.getId());
        coAo.setMaCoAo(coAoDTO.getMaCoAo());
        coAo.setTenCoAo(coAoDTO.getTenCoAo());
        coAo.setTrangThai(coAoDTO.getTrangThai());
        return coAo;
    }

    @Override
    public List<CoAoDTO> getList() {
        List<CoAo> coAoList = coAoRepository.findAll();
        return coAoList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CoAoDTO getCoAoById(Integer id) {
        CoAo coAo = coAoRepository.findById(id).orElseThrow(()->new RuntimeException("cổ áo không tồn tại với ID:"+id));
        return convertToDto(coAo);
    }

    @Override
    public CoAoDTO createEndUpdateCoAo(CoAoDTO coAoDTO) {
        CoAo coAo = convertToEntity(coAoDTO);
        CoAo coAoSaved = coAoRepository.save(coAo);
        return convertToDto(coAoSaved);
    }

    @Override
    public void deleteCoAo(Integer id) {
        CoAo coAo = coAoRepository.findById(id).orElseThrow(() -> new RuntimeException("cổ áo không tồn tại với id: " +id));
        coAoRepository.delete(coAo);
    }
}

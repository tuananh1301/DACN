package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.CoAoDTO;

import java.util.List;

public interface CoAoService {
    List<CoAoDTO> getList();
    CoAoDTO getCoAoById(Integer id);
    CoAoDTO createEndUpdateCoAo(CoAoDTO coAoDTO);
    void deleteCoAo(Integer id);
}

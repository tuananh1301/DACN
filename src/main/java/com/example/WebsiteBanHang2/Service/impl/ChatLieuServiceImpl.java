package com.example.WebsiteBanHang2.Service.impl;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Model.ChatLieu;
import com.example.WebsiteBanHang2.Repository.ChatLieuRepository;
import com.example.WebsiteBanHang2.Service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
     ChatLieuRepository chatLieuRepository;

    private ChatLieuDTO convertToDTO(ChatLieu chatLieu) {
        ChatLieuDTO dto = new ChatLieuDTO();
        dto.setId(chatLieu.getId());
        dto.setMaChatLieu(chatLieu.getMaChatLieu());
        dto.setTenChatLieu(chatLieu.getTenChatLieu());
        dto.setTrangThai(chatLieu.getTrangThai());
        return dto;
    }

    private ChatLieu convertToEntity(ChatLieuDTO dto) {
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setId(dto.getId());
        chatLieu.setMaChatLieu(dto.getMaChatLieu());
        chatLieu.setTenChatLieu(dto.getTenChatLieu());
        chatLieu.setTrangThai(dto.getTrangThai());
        return chatLieu;
    }

    @Override
    public List<ChatLieuDTO> getList() {
        List<ChatLieu> chatLieus = chatLieuRepository.findAll();
        return chatLieus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChatLieuDTO getChatLieuById(Integer id) {
        ChatLieu chatLieu = chatLieuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chất liệu không tồn tại với ID: " + id));
        return convertToDTO(chatLieu);
    }

    @Override
    public ChatLieuDTO createEndUpdateChatLieu(ChatLieuDTO chatLieuDTO) {
        ChatLieu chatLieu = convertToEntity(chatLieuDTO);
        ChatLieu saved = chatLieuRepository.save(chatLieu);
        return convertToDTO(saved);
    }

    @Override
    public void deleteChatLieu(Integer id) {
        ChatLieu chatLieu = chatLieuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chất liệu không tồn tại với ID: " + id));
        chatLieuRepository.delete(chatLieu);
    }
}

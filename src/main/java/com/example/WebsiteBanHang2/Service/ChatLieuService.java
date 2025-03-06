package com.example.WebsiteBanHang2.Service;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieuDTO> getList();
    ChatLieuDTO getChatLieuById(Integer id);
    ChatLieuDTO createEndUpdateChatLieu(ChatLieuDTO chatLieuDTO);
    void deleteChatLieu(Integer id);
}

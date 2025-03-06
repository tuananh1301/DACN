package com.example.WebsiteBanHang2.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chat_lieu")
public class ChatLieu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_chat_lieu")
    private String maChatLieu;

    @Column(name = "ten_chat_lieu")
    private String tenChatLieu;

    @Column(name = "trang_thai")
    private Byte trangThai;


}

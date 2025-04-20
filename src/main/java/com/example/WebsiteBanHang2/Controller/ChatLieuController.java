package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;

    // 1) Full page (khi load trực tiếp /admin/chatlieu)
    @GetMapping("/chatlieu")
    public String hienThi(Model model) {
        model.addAttribute("listChatLieu", chatLieuService.getList());
        return "ChatLieu/HienThi";
    }

    // 2) Fragment cho AJAX
    @GetMapping("/fragment/chatlieu")
    public String fragmentChatLieu(Model model) {
        model.addAttribute("listChatLieu", chatLieuService.getList());
        return "ChatLieu/HienThi :: content";
    }

    // 3) Chi tiết (fragment)
    @GetMapping("/detailchatlieu/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cl", chatLieuService.getChatLieuById(id));
        return "ChatLieu/Detail :: content";
    }

    // 4) Xóa qua AJAX
    @GetMapping("/deletechatlieu")
    public String delete(@RequestParam("id") Integer id, Model model) {
        chatLieuService.deleteChatLieu(id);
        model.addAttribute("listChatLieu", chatLieuService.getList());
        return "ChatLieu/HienThi :: content";
    }

    // 5) Thêm via AJAX
    @PostMapping("/addchatlieu")
    public String add(ChatLieuDTO chatLieu, Model model) {
        chatLieuService.createEndUpdateChatLieu(chatLieu);
        model.addAttribute("listChatLieu", chatLieuService.getList());
        return "ChatLieu/HienThi :: content";
    }

    // 6) Cập nhật via AJAX
    @PostMapping("/updatechatlieu")
    public String update(ChatLieuDTO chatLieu, Model model) {
        chatLieuService.createEndUpdateChatLieu(chatLieu);
        model.addAttribute("listChatLieu", chatLieuService.getList());
        return "ChatLieu/HienThi :: content";
    }
}

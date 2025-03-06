package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.ChatLieuDTO;
import com.example.WebsiteBanHang2.Model.ChatLieu;
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

    @GetMapping("/chatlieu")
    public String hienThi(Model model) {
        model.addAttribute("listChatLieu", chatLieuService.getList());
        return "ChatLieu/HienThi";
    }
    @GetMapping("/detailchatlieu/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cl", chatLieuService.getChatLieuById(id));
        return "ChatLieu/Detail";
    }
    @GetMapping("/deletechatlieu")
    public String delete(@RequestParam("id") Integer id) {
        chatLieuService.deleteChatLieu(id);
        return "redirect:/admin/chatlieu";
    }
    @PostMapping("/addchatlieu")
    public String add(ChatLieuDTO chatLieu) {
        chatLieuService.createEndUpdateChatLieu(chatLieu);
        return "redirect:/admin/chatlieu";
    }
    @PostMapping("/updatechatlieu")
    public String update(ChatLieuDTO chatLieu) {
        chatLieuService.createEndUpdateChatLieu(chatLieu);
        return "redirect:/admin/chatlieu";
    }
}

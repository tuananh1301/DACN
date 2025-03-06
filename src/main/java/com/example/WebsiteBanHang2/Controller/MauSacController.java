package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.MauSacDTO;
import com.example.WebsiteBanHang2.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/mausac")
    public String hienThi(Model model) {
        model.addAttribute("listMauSac", mauSacService.getList());
        return "MauSac/HienThi";
    }
    @GetMapping("/detailmausac/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ms", mauSacService.getMauSacById(id));
        return "MauSac/Detail";
    }
    @GetMapping("/deletemausac")
    public String delete(@RequestParam("id") Integer id) {
        mauSacService.deleteMauSac(id);
        return "redirect:/admin/mausac";
    }
    @PostMapping("/addmausac")
    public String add(MauSacDTO MauSac) {
        mauSacService.createEndUpdateMauSac(MauSac);
        return "redirect:/admin/mausac";
    }
    @PostMapping("/updatemausac")
    public String update(MauSacDTO MauSac) {
        mauSacService.createEndUpdateMauSac(MauSac);
        return "redirect:/admin/mausac";
    }
}

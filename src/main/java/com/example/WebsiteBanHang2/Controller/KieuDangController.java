package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.KieuDangDTO;
import com.example.WebsiteBanHang2.Model.KieuDang;
import com.example.WebsiteBanHang2.Service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class KieuDangController {
    @Autowired
    KieuDangService kieudangService;
    @GetMapping("/kieudang")
    public String kieudang(Model model) {
        model.addAttribute("listKieuDang", kieudangService.getList());
        return "KieuDang/HienThi";
    }
    @GetMapping("/detailkieudang/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("kd", kieudangService.getKieuDangById(id));
        return "KieuDang/Detail";
    }
    @GetMapping("/deletekieudang")
    public String delete(@RequestParam("id") Integer id) {
        kieudangService.deleteKieuDang(id);
        return "redirect:/admin/kieudang";
    }
    @PostMapping("/addkieudang")
    public String add(KieuDangDTO kieudang) {
        kieudangService.createEndUpdateKieuDang(kieudang);
        return "redirect:/admin/kieudang";
    }
    @PostMapping("/updatekieudang")
    public String update(KieuDangDTO kieudang) {
        kieudangService.createEndUpdateKieuDang(kieudang);
        return "redirect:/admin/kieudang";
    }
}

package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.ThietKeDTO;
import com.example.WebsiteBanHang2.Service.ThietKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ThietKeController {
    @Autowired
    private ThietKeService thietKeService;

    @GetMapping("/thietke")
    public String hienThi(Model model) {
        model.addAttribute("listThietKe", thietKeService.getList());
        return "ThietKe/HienThi";
    }
    @GetMapping("/detailthietke/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tk", thietKeService.getThietKeById(id));
        return "ThietKe/Detail";
    }
    @GetMapping("/deletethietke")
    public String delete(@RequestParam("id") Integer id) {
        thietKeService.deleteThietKe(id);
        return "redirect:/admin/thietke";
    }
    @PostMapping("/addthietke")
    public String add(ThietKeDTO ThietKe) {
        thietKeService.createEndUpdateThietKe(ThietKe);
        return "redirect:/admin/thietke";
    }
    @PostMapping("/updatethietke")
    public String update(ThietKeDTO ThietKe) {
        thietKeService.createEndUpdateThietKe(ThietKe);
        return "redirect:/admin/thietke";
    }
}

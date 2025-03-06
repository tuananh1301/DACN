package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.DanhMucDTO;
import com.example.WebsiteBanHang2.Model.DanhMuc;
import com.example.WebsiteBanHang2.Service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class DanhMucController {
    @Autowired
    DanhMucService danhMucService;
    @GetMapping("/danhmuc")
    public String getList(Model model) {
        model.addAttribute("listDanhMuc", danhMucService.getList());
        return "DanhMuc/HienThi";
    }
    @GetMapping("/detaildanhmuc/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dm", danhMucService.getDanhMucById(id));
        return "DanhMuc/Detail";
    }
    @GetMapping("/deletedanhmuc")
    public String delete(@RequestParam("id") Integer id) {
        danhMucService.deleteDanhMuc(id);
        return "redirect:/admin/danhmuc";
    }
    @PostMapping("/adddanhmuc")
    public String add(DanhMucDTO danhMuc) {
        danhMucService.createEndUpdateDanhMuc(danhMuc);
        return "redirect:/admin/danhmuc";
    }
    @PostMapping("/updatedanhmuc")
    public String update(DanhMucDTO danhMuc) {
        danhMucService.createEndUpdateDanhMuc(danhMuc);
        return "redirect:/admin/danhmuc";
    }
}

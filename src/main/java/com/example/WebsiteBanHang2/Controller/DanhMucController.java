package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.DanhMucDTO;
import com.example.WebsiteBanHang2.Service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class DanhMucController {

    @Autowired
    private DanhMucService danhMucService;

    // 1) Khi load trực tiếp /admin/danhmuc (full page)
    @GetMapping("/danhmuc")
    public String getList(Model model) {
        model.addAttribute("listDanhMuc", danhMucService.getList());
        return "DanhMuc/HienThi";
    }

    // 2) Fragment để AJAX load danh sách
    @GetMapping("/fragment/danhmuc")
    public String danhMucFragment(Model model) {
        model.addAttribute("listDanhMuc", danhMucService.getList());
        return "DanhMuc/HienThi :: content";
    }

    // 3) Chi tiết (AJAX fragment)
    @GetMapping("/detaildanhmuc/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("dm", danhMucService.getDanhMucById(id));
        return "DanhMuc/Detail :: content";
    }

    // 4) Xóa qua AJAX
    @GetMapping("/deletedanhmuc")
    public String delete(@RequestParam("id") Integer id, Model model) {
        danhMucService.deleteDanhMuc(id);
        model.addAttribute("listDanhMuc", danhMucService.getList());
        return "DanhMuc/HienThi :: content";
    }

    // 5) Thêm qua AJAX
    @PostMapping("/adddanhmuc")
    public String add(DanhMucDTO danhMuc, Model model) {
        danhMucService.createEndUpdateDanhMuc(danhMuc);
        model.addAttribute("listDanhMuc", danhMucService.getList());
        return "DanhMuc/HienThi :: content";
    }

    // 6) Cập nhật qua AJAX
    @PostMapping("/updatedanhmuc")
    public String update(DanhMucDTO danhMuc, Model model) {
        danhMucService.createEndUpdateDanhMuc(danhMuc);
        model.addAttribute("listDanhMuc", danhMucService.getList());
        return "DanhMuc/HienThi :: content";
    }
}

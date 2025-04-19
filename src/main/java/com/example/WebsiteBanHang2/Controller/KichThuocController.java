package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.KichThuocDTO;
import com.example.WebsiteBanHang2.Service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class KichThuocController {

    @Autowired
    private KichThuocService kichThuocService;

    // Trả về fragment danh sách kích thước
    @GetMapping("/fragment/kichthuoc")
    public String kichThuocFragment(Model model) {
        model.addAttribute("listKichThuoc", kichThuocService.getList());
        return "KichThuoc/HienThi :: content";
    }

    // Trả về fragment chi tiết kích thước
    @GetMapping("/detailkichthuoc/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("kt", kichThuocService.getKichThuocById(id));
        return "KichThuoc/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deletekichthuoc")
    public String delete(@RequestParam("id") Integer id, Model model) {
        kichThuocService.deleteKichThuoc(id);
        model.addAttribute("listKichThuoc", kichThuocService.getList());
        // Trả về thẳng fragment, không redirect
        return "KichThuoc/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addkichthuoc")
    public String add(KichThuocDTO kichThuoc, Model model) {
        kichThuocService.createEndUpdateKichThuoc(kichThuoc);
        model.addAttribute("listKichThuoc", kichThuocService.getList());
        return "KichThuoc/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updatekichthuoc")
    public String update(KichThuocDTO kichThuoc, Model model) {
        kichThuocService.createEndUpdateKichThuoc(kichThuoc);
        model.addAttribute("listKichThuoc", kichThuocService.getList());
        return "KichThuoc/HienThi :: content";
    }
}

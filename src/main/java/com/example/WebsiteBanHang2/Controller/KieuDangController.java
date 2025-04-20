package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.KieuDangDTO;
import com.example.WebsiteBanHang2.Service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class KieuDangController {

    @Autowired
    private KieuDangService kieudangService;

    // Trả về fragment danh sách kiểu dáng
    @GetMapping("/fragment/kieudang")
    public String kieudangFragment(Model model) {
        model.addAttribute("listKieuDang", kieudangService.getList());
        return "KieuDang/HienThi :: content";
    }

    // Trả về fragment chi tiết kiểu dáng
    @GetMapping("/detailkieudang/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("kd", kieudangService.getKieuDangById(id));
        return "KieuDang/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deletekieudang")
    public String delete(@RequestParam("id") Integer id, Model model) {
        kieudangService.deleteKieuDang(id);
        model.addAttribute("listKieuDang", kieudangService.getList());
        // Trả về thẳng fragment, không redirect
        return "KieuDang/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addkieudang")
    public String add(KieuDangDTO kieudang, Model model) {
        kieudangService.createEndUpdateKieuDang(kieudang);
        model.addAttribute("listKieuDang", kieudangService.getList());
        return "KieuDang/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updatekieudang")
    public String update(KieuDangDTO kieudang, Model model) {
        kieudangService.createEndUpdateKieuDang(kieudang);
        model.addAttribute("listKieuDang", kieudangService.getList());
        return "KieuDang/HienThi :: content";
    }
}

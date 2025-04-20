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

    // Trả về fragment danh sách màu sắc
    @GetMapping("/fragment/mausac")
    public String mauSacFragment(Model model) {
        model.addAttribute("listMauSac", mauSacService.getList());
        return "MauSac/HienThi :: content";
    }

    // Trả về fragment chi tiết màu sắc
    @GetMapping("/detailmausac/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ms", mauSacService.getMauSacById(id));
        return "MauSac/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deletemausac")
    public String delete(@RequestParam("id") Integer id, Model model) {
        mauSacService.deleteMauSac(id);
        model.addAttribute("listMauSac", mauSacService.getList());
        // Trả về thẳng fragment, không redirect
        return "MauSac/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addmausac")
    public String add(MauSacDTO mauSac, Model model) {
        mauSacService.createEndUpdateMauSac(mauSac);
        model.addAttribute("listMauSac", mauSacService.getList());
        return "MauSac/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updatemausac")
    public String update(MauSacDTO mauSac, Model model) {
        mauSacService.createEndUpdateMauSac(mauSac);
        model.addAttribute("listMauSac", mauSacService.getList());
        return "MauSac/HienThi :: content";
    }
}

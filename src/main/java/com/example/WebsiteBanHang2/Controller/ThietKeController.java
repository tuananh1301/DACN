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

    // Trả về fragment danh sách thiết kế
    @GetMapping("/fragment/thietke")
    public String thietKeFragment(Model model) {
        model.addAttribute("listThietKe", thietKeService.getList());
        return "ThietKe/HienThi :: content";
    }

    // Trả về fragment chi tiết thiết kế
    @GetMapping("/detailthietke/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tk", thietKeService.getThietKeById(id));
        return "ThietKe/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deletethietke")
    public String delete(@RequestParam("id") Integer id, Model model) {
        thietKeService.deleteThietKe(id);
        model.addAttribute("listThietKe", thietKeService.getList());
        // Trả về thẳng fragment, không redirect
        return "ThietKe/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addthietke")
    public String add(ThietKeDTO thietKe, Model model) {
        thietKeService.createEndUpdateThietKe(thietKe);
        model.addAttribute("listThietKe", thietKeService.getList());
        return "ThietKe/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updatethietke")
    public String update(ThietKeDTO thietKe, Model model) {
        thietKeService.createEndUpdateThietKe(thietKe);
        model.addAttribute("listThietKe", thietKeService.getList());
        return "ThietKe/HienThi :: content";
    }
}

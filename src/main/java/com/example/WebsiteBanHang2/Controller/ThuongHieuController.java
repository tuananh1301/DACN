package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.ThuongHieuDTO;
import com.example.WebsiteBanHang2.Service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService thuongHieuService;

    // Trả về fragment danh sách thương hiệu
    @GetMapping("/fragment/thuonghieu")
    public String thuongHieuFragment(Model model) {
        model.addAttribute("listThuongHieu", thuongHieuService.getList());
        return "ThuongHieu/HienThi :: content";
    }

    // Trả về fragment chi tiết thương hiệu
    @GetMapping("/detailthuonghieu/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("th", thuongHieuService.getThuongHieuById(id));
        return "ThuongHieu/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deletethuonghieu")
    public String delete(@RequestParam("id") Integer id, Model model) {
        thuongHieuService.deleteThuongHieu(id);
        model.addAttribute("listThuongHieu", thuongHieuService.getList());
        // Trả về thẳng fragment, không redirect
        return "ThuongHieu/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addthuonghieu")
    public String add(ThuongHieuDTO thuongHieu, Model model) {
        thuongHieuService.createEndUpdateThuongHieu(thuongHieu);
        model.addAttribute("listThuongHieu", thuongHieuService.getList());
        return "ThuongHieu/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updatethuonghieu")
    public String update(ThuongHieuDTO thuongHieu, Model model) {
        thuongHieuService.createEndUpdateThuongHieu(thuongHieu);
        model.addAttribute("listThuongHieu", thuongHieuService.getList());
        return "ThuongHieu/HienThi :: content";
    }
}

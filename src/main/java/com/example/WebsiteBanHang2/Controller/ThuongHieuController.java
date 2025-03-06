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

    @GetMapping("/thuonghieu")
    public String hienThi(Model model) {
        model.addAttribute("listThuongHieu", thuongHieuService.getList());
        return "ThuongHieu/HienThi";
    }
    @GetMapping("/detailthuonghieu/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("th", thuongHieuService.getThuongHieuById(id));
        return "ThuongHieu/Detail";
    }
    @GetMapping("/deletethuonghieu")
    public String delete(@RequestParam("id") Integer id) {
        thuongHieuService.deleteThuongHieu(id);
        return "redirect:/admin/thuonghieu";
    }
    @PostMapping("/addthuonghieu")
    public String add(ThuongHieuDTO ThuongHieu) {
        System.out.println(ThuongHieu.getMaThuongHieu());
        System.out.println(ThuongHieu.getTenThuongHieu());
        thuongHieuService.createEndUpdateThuongHieu(ThuongHieu);
        return "redirect:/admin/thuonghieu";
    }
    @PostMapping("/updatethuonghieu")
    public String update(ThuongHieuDTO ThuongHieu) {
        thuongHieuService.createEndUpdateThuongHieu(ThuongHieu);
        return "redirect:/admin/thuonghieu";
    }
}

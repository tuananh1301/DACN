package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.SanPhamDTO;
import com.example.WebsiteBanHang2.Model.DanhMuc;
import com.example.WebsiteBanHang2.Repository.DanhMucRepository;
import com.example.WebsiteBanHang2.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class SanPhamController {
    @Autowired
    private DanhMucRepository danhMucRepository;

    @ModelAttribute("listDanhMuc")
    public List<DanhMuc> listDanhMuc() {
        return danhMucRepository.findAll();
    }

    @Autowired
    private SanPhamService sanPhamService;

    // 1) Full page (dùng khi tải thẳng /admin/sanpham)
    @GetMapping("/sanpham")
    public String hienThi(Model model) {
        model.addAttribute("listSanPham", sanPhamService.getList());
        return "SanPham/HienThi";
    }

    // 2) Fragment cho AJAX
    @GetMapping("/fragment/sanpham")
    public String sanPhamFragment(Model model) {
        model.addAttribute("listSanPham", sanPhamService.getList());
        return "SanPham/HienThi :: content";
    }
    @GetMapping("/detailsanpham/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sp", sanPhamService.getSanPhamDTOById(id));
        return "SanPham/Detail :: content";
    }

    // 3) Xóa qua AJAX
    @GetMapping("/deletesanpham")
    public String delete(@RequestParam("id") Integer id, Model model) {
        sanPhamService.deleteSanPhamDTO(id);
        model.addAttribute("listSanPham", sanPhamService.getList());
        return "SanPham/HienThi :: content";
    }

    // 4) Thêm via AJAX
    @PostMapping("/addsanpham")
    public String add(SanPhamDTO sanPham, Model model) {
        sanPhamService.createEndUpdateSanPhamDTO(sanPham);
        model.addAttribute("listSanPham", sanPhamService.getList());
        return "SanPham/HienThi :: content";
    }

    // 5) Cập nhật via AJAX
    @PostMapping("/updatesanpham")
    public String update(SanPhamDTO sanPham, Model model) {
        sanPhamService.createEndUpdateSanPhamDTO(sanPham);
        model.addAttribute("listSanPham", sanPhamService.getList());
        return "SanPham/HienThi :: content";
    }
}

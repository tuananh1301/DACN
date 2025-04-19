package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.*;
import com.example.WebsiteBanHang2.Repository.*;
import com.example.WebsiteBanHang2.Service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class SanPhamChiTietController {
    private static final Logger logger = LoggerFactory.getLogger(SanPhamChiTietController.class);

    @Autowired
    SanPhamRepository sanPhamRepository;
    @ModelAttribute("listSP")
    List<SanPham> listSP() {
        return sanPhamRepository.findAll();
    }

    @Autowired
    KichThuocRepository kichThuocRepository;
    @ModelAttribute("listKT")
    List<KichThuoc> listKT() {
        return kichThuocRepository.findAll();
    }

    @Autowired
    MauSacRepository mauSacRepository;
    @ModelAttribute("listMS")
    List<MauSac> listMS() {
        return mauSacRepository.findAll();
    }

    @Autowired
    ChatLieuRepository chatLieuRepository;
    @ModelAttribute("listCL")
    List<ChatLieu> listCL() {
        return chatLieuRepository.findAll();
    }

    @Autowired
    KieuDangRepository kieuDangRepository;
    @ModelAttribute("listKD")
    List<KieuDang> listKD() {
        return kieuDangRepository.findAll();
    }

    @Autowired
    CoAoRepository coAoRepository;
    @ModelAttribute("listCA")
    List<CoAo> listCA() {
        return coAoRepository.findAll();
    }

    @Autowired
    ThietKeRepository thietKeRepository;
    @ModelAttribute("listTK")
    List<ThietKe> listTK() {
        List<ThietKe> list = thietKeRepository.findAll();
        logger.info("listTK: {}", list);
        return list;
    }

    @Autowired
    ThuongHieuRepository thuongHieuRepository;
    @ModelAttribute("listTH")
    List<ThuongHieu> listTH() {
        return thuongHieuRepository.findAll();
    }

    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;

    // Trả về fragment danh sách sản phẩm chi tiết
    @GetMapping("/fragment/SPCT")
    public String sanPhamChiTietFragment(Model model) {
        model.addAttribute("listSanPhamChiTiet", sanPhamChiTietService.getList());
        return "SPChiTiet/HienThi :: content";
    }

    // Trả về fragment chi tiết sản phẩm
    @GetMapping("/detailSPCT/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        SanPhamChiTietDTO spct = sanPhamChiTietService.getSanPhamChiTietById(id);
        model.addAttribute("spct", spct);
        return "SPChiTiet/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deleteSPCT")
    public String delete(@RequestParam("id") Integer id, Model model) {
        sanPhamChiTietService.deleteSanPhamChiTiet(id);
        model.addAttribute("listSanPhamChiTiet", sanPhamChiTietService.getList());
        // Trả về thẳng fragment, không redirect
        return "SPChiTiet/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addSPCT")
    public String add(SanPhamChiTietDTO sanPhamChiTiet, Model model) {
        sanPhamChiTiet.setNgayTao(LocalDate.now());
        sanPhamChiTiet.setNguoiCapNhat("ADMIN");
        sanPhamChiTietService.createEndUpdateSanPhamChiTiet(sanPhamChiTiet);
        model.addAttribute("listSanPhamChiTiet", sanPhamChiTietService.getList());
        return "SPChiTiet/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updateSPCT")
    public String update(SanPhamChiTietDTO sanPhamChiTiet, Model model) {
        sanPhamChiTiet.setNgayCapNhat(LocalDate.now());
        sanPhamChiTietService.createEndUpdateSanPhamChiTiet(sanPhamChiTiet);
        model.addAttribute("listSanPhamChiTiet", sanPhamChiTietService.getList());
        return "SPChiTiet/HienThi :: content";
    }
}

package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.CoAoDTO;
import com.example.WebsiteBanHang2.Service.CoAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CoAoController {

    @Autowired
    private CoAoService coAoService;

    // Trả về fragment danh sách cỡ áo
    @GetMapping("/fragment/coao")
    public String coaoFragment(Model model) {
        model.addAttribute("listCoAo", coAoService.getList());
        return "CoAo/HienThi :: content";
    }

    // Trả về fragment chi tiết
    @GetMapping("/detailcoao/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ca", coAoService.getCoAoById(id));
        return "CoAo/Detail :: content";
    }

    // Xóa và trả về fragment danh sách mới
    @GetMapping("/deletecoao")
    public String delete(@RequestParam("id") Integer id, Model model) {
        coAoService.deleteCoAo(id);
        model.addAttribute("listCoAo", coAoService.getList());
        // Trả về thẳng fragment, không redirect
        return "CoAo/HienThi :: content";
    }

    // Thêm và trả về fragment danh sách mới
    @PostMapping("/addcoao")
    public String add(CoAoDTO coAo, Model model) {
        coAoService.createEndUpdateCoAo(coAo);
        model.addAttribute("listCoAo", coAoService.getList());
        return "CoAo/HienThi :: content";
    }

    // Cập nhật và trả về fragment danh sách mới
    @PostMapping("/updatecoao")
    public String update(CoAoDTO coAo, Model model) {
        coAoService.createEndUpdateCoAo(coAo);
        model.addAttribute("listCoAo", coAoService.getList());
        return "CoAo/HienThi :: content";
    }
}

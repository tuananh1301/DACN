package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.GioHang.CartItem;
import com.example.WebsiteBanHang2.Model.GioHang.ShoppingCart;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import com.example.WebsiteBanHang2.Repository.SanPhamChiTietRepository;
import com.example.WebsiteBanHang2.Service.SanPhamChiTietService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class HienThiSanPhamController {
    @Autowired
    SanPhamChiTietService sanPhamChiTietService;

    @GetMapping("/products")
    public String hienThiSanPham(Model model) {
        model.addAttribute("sanPhamChiTiet", sanPhamChiTietService.getList());
        return "HienThiSanPham/Home";
    }
    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("id") Integer sanPhamChiTietId,
                            @RequestParam("soLuongMua") Integer soLuongMua,
                            HttpSession session) {
        SanPhamChiTietDTO product = sanPhamChiTietService.getSanPhamChiTietById(sanPhamChiTietId);
        CartItem cartItem = new CartItem(
                product.getId(),
                product.getSanPhamId().getTenSanPham(),
                soLuongMua,
                product.getDonGia()
        );

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        return "redirect:/customer/products";
    }
    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        System.out.println("Cart items: " + cart.getItems());
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        model.addAttribute("cart", cart);
        System.out.println("Cart items: " + cart.getItems());
        return "HienThiSanPham/Cart";
    }
    @PostMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("id") Integer sanPhamChiTietId,
                                 HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            cart.removeItem(sanPhamChiTietId);
        }
        return "redirect:/customer/cart";
    }
}

package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Model.GioHang.ShoppingCart;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Repository.DonViVanChuyenRepository;
import com.example.WebsiteBanHang2.Service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private DonViVanChuyenRepository donViVanChuyenRepository;
    @GetMapping("/checkout")
    public String showCheckout(HttpSession session, Model model) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            return "redirect:/customer/products";
        }
        model.addAttribute("cart", cart);
        model.addAttribute("donViVanChuyens", donViVanChuyenRepository.findAll());
        model.addAttribute("orderForm", new OrderForm());
        return "DatHang/CheckOut";
    }
    @PostMapping("/place-order")
    public String placeOrder(@ModelAttribute("orderForm") OrderForm orderForm,
                             HttpSession session,
                             @AuthenticationPrincipal UserAccount user) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        System.out.println("User: " + (user != null ? user.getEmail() : "null"));
        if (cart == null || cart.getItems().isEmpty()) {
            return "redirect:/customer/products";
        }
        if (user == null) {
            System.out.println("User is null, redirecting to login");
            return "redirect:/login";
        }
        HoaDon hoaDon = orderService.placeOrder(user, cart, orderForm.getDiaChiGiaoHang(), orderForm.getIdDonViVanChuyen());
        session.removeAttribute("cart");

        return "redirect:/customer/order-success?orderId=" + hoaDon.getId();
    }

    @GetMapping("/order-success")
    public String orderSuccess(@RequestParam("orderId") Integer orderId, Model model) {
        model.addAttribute("orderId", orderId);
        return "DatHang/DatThanhCong";
    }
}
@Data
class OrderForm {
    private String diaChiGiaoHang;
    private Integer idDonViVanChuyen;
}

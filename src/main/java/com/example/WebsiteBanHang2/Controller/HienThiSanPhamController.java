package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.SanPhamChiTietDTO;
import com.example.WebsiteBanHang2.Model.GioHang.CartItem;
import com.example.WebsiteBanHang2.Model.GioHang.ShoppingCart;
import com.example.WebsiteBanHang2.Model.SanPhamChiTiet;
import com.example.WebsiteBanHang2.Repository.DonViVanChuyenRepository;
import com.example.WebsiteBanHang2.Repository.SanPhamChiTietRepository;
import com.example.WebsiteBanHang2.Service.SanPhamChiTietService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class HienThiSanPhamController {
    @Autowired
    SanPhamChiTietService sanPhamChiTietService;
    @Autowired
    DonViVanChuyenRepository donViVanChuyenRepository;

    @GetMapping("/trangchu")
    public String hienThiSanPham(Model model) {
        List<SanPhamChiTiet> sanPhamChiTietList = sanPhamChiTietService.getBySanPham();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,##0", symbols);

        List<String> formattedPrices = sanPhamChiTietList.stream()
                .map(spct -> spct.getDonGia() != null
                        ? formatter.format(spct.getDonGia()) + "₫"
                        : "N/A")
                .collect(Collectors.toList());

        model.addAttribute("sanPhamChiTiet", sanPhamChiTietList);
        model.addAttribute("formattedPrices", formattedPrices);

        return "HienThiSanPham/Home";
    }
    @GetMapping("/san-pham/{id}")
    public String sanPham(Model model, @PathVariable Integer id) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.findSanPhamChiTietById(id);
        Integer soLuong = sanPhamChiTietService.findSoLuongBySanPhamChiTiet(id);
        if(sanPhamChiTiet == null) {
            return "redirect:/trangchu";
        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,##0", symbols);
        String formattedPrice = formatter.format(sanPhamChiTiet.getDonGia()) + "₫";
        Integer idSP = sanPhamChiTiet.getSanPhamId().getId();
        model.addAttribute("KichThuoc", sanPhamChiTietService.getKichThuocBySanPham(idSP));
        model.addAttribute("SoLuong", soLuong);
        model.addAttribute("MauSac", sanPhamChiTietService.getMauSacBySanPham(idSP));
        model.addAttribute("spct", sanPhamChiTiet);
        model.addAttribute("formattedPrice", formattedPrice);
        return "HienThiSanPham/ChiTiet";
    }


    @PostMapping("/add-to-cart")
    public String addToCart(
            @RequestParam("id") Integer sanPhamChiTietId,
            @RequestParam("soLuong") Integer soLuongMua,
            @RequestParam("mauSac") String mauSac,
            @RequestParam("kichThuoc") String kichThuoc,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        try {
            SanPhamChiTietDTO product = sanPhamChiTietService.getSanPhamChiTietById(sanPhamChiTietId);
            if (product == null) {
                redirectAttributes.addFlashAttribute("error", "Sản phẩm không tồn tại");
                return "redirect:/customer/san-pham/" + sanPhamChiTietId;
            }
            if (soLuongMua < 1 || soLuongMua > product.getSoLuong()) {
                redirectAttributes.addFlashAttribute("error", "Số lượng không hợp lệ, chỉ còn " + product.getSoLuong() + " sản phẩm");
                return "redirect:/customer/san-pham/" + sanPhamChiTietId;
            }
            CartItem cartItem = new CartItem(
                    product.getId(),
                    product.getSanPhamId().getTenSanPham(),
                    soLuongMua,
                    product.getDonGia(),
                    mauSac,
                    kichThuoc,
                    product.getPhoto()
            );
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            cart.addItem(cartItem);
            redirectAttributes.addFlashAttribute("message", "Đã thêm sản phẩm vào giỏ hàng!");
            return "redirect:/customer/cart";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi khi thêm vào giỏ: " + e.getMessage());
            return "redirect:/customer/san-pham/" + sanPhamChiTietId;
        }
    }
    @PostMapping("/buy-now")
    public String buyNow(
            @RequestParam("id") Integer sanPhamChiTietId,
            @RequestParam("soLuong") Integer soLuongMua,
            @RequestParam("mauSac") String mauSac,
            @RequestParam("kichThuoc") String kichThuoc,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        try {
            SanPhamChiTietDTO product = sanPhamChiTietService.getSanPhamChiTietById(sanPhamChiTietId);
            if (product == null) {
                redirectAttributes.addFlashAttribute("error", "Sản phẩm không tồn tại");
                return "redirect:/customer/san-pham/" + sanPhamChiTietId;
            }

            if (soLuongMua < 1 || soLuongMua > product.getSoLuong()) {
                redirectAttributes.addFlashAttribute("error", "Số lượng không hợp lệ, chỉ còn " + product.getSoLuong() + " sản phẩm");
                return "redirect:/customer/san-pham/" + sanPhamChiTietId;
            }

            CartItem buyNowItem = new CartItem(
                    product.getId(),
                    product.getSanPhamId().getTenSanPham(),
                    soLuongMua,
                    product.getDonGia(),
                    mauSac,
                    kichThuoc,
                    product.getPhoto()
            );

            // Lưu riêng vào session (KHÔNG thêm vào giỏ hàng chính)
            session.setAttribute("buyNowItem", buyNowItem);

            return "redirect:/customer/buy-now/checkout";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Lỗi khi mua ngay: " + e.getMessage());
            return "redirect:/customer/buy-now/checkout";
        }
    }

    @GetMapping("/buy-now/checkout")
    public String showBuyNowCheckout(HttpSession session, Model model) {
        CartItem buyNowItem = (CartItem) session.getAttribute("buyNowItem");

        if (buyNowItem == null) {
            return "redirect:/customer/trangchu";
        }

        // Tạo giỏ tạm thời để hiển thị
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(buyNowItem);

        model.addAttribute("cart", cart);
        model.addAttribute("donViVanChuyens", donViVanChuyenRepository.findAll());
        model.addAttribute("orderForm", new OrderForm());

        return "DatHang/CheckOutMuaNgay";  // Trang riêng biệt (có thể dùng lại CheckOut.html nếu bạn không cần tùy biến)
    }



    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        String tongTien = currencyFormatter.format(cart.getTongTien());

        List<CartItem> items = cart.getItems();
        for (CartItem item : items) {
            item.setFormattedDonGia(currencyFormatter.format(item.getDonGia()));
            item.setFormattedThanhTien(currencyFormatter.format(item.getThanhTien()));
        }

        model.addAttribute("tien", tongTien);
        model.addAttribute("cart", cart);
        model.addAttribute("totalItems", cart.getTotalItems());
        return "HienThiSanPham/Cart";
    }
    @GetMapping("/remove-from-cart/{id}")
    public String removeFromCart(@PathVariable Integer id, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            cart.removeItem(id);
            session.setAttribute("cart", cart);
        }
        return "redirect:/customer/cart";
    }



}
@Controller
class controllerHome{
    @GetMapping("/trangchu")
    public String forwardTrangChu() {
        return "forward:/customer/trangchu";
    }
}

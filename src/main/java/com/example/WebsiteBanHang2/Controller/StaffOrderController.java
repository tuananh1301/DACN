package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Dto.HoaDonDTO;
import com.example.WebsiteBanHang2.Model.HoaDon;
import com.example.WebsiteBanHang2.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff/orders")
public class StaffOrderController {
    @Autowired
    private OrderService orderService;

    // Xem danh sách đơn hàng PENDING
    @GetMapping("")
    public String getPendingOrders(Model model) {
        model.addAttribute("Pendings", orderService.getPendingOrders());
        model.addAttribute("Shippeds", orderService.getShippedOrders());
        model.addAttribute("Delivereds", orderService.getDeliveredOrders());
        model.addAttribute("Compeleteds", orderService.getCompeletedOrders());
        model.addAttribute("Cancelleds", orderService.getCancelledOrders());
        return "OrderStatus/Order";
    }

    // Xác nhận đơn hàng
    @GetMapping("/{orderId}/confirm")
    public String confirmOrder(@PathVariable Integer orderId) {
        orderService.confirmOrder(orderId);
        return "redirect:/staff/orders";
    }
    // Xác nhận đơn hàng
    @GetMapping("/{orderId}/confirmDelivered")
    public String confirmDelivered(@PathVariable Integer orderId) {
        orderService.confirmDelivered(orderId);
        return "redirect:/staff/orders";
    }
    @GetMapping("/{orderId}/confirmCompeleted")
    public String confirmCompeleted(@PathVariable Integer orderId) {
        orderService.confirmCompeleted(orderId);
        return "redirect:/staff/orders";
    }

    // Hủy đơn hàng
    @GetMapping("/{orderId}/cancel")
    public String cancelOrder(@PathVariable Integer orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/staff/orders";
    }
}
